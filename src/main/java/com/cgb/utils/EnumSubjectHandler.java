package com.cgb.utils;

import com.cgb.pojo.Subject;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnumSubjectHandler extends BaseTypeHandler<Subject> {

    /**
     * 设置配置文件设置的转换类以及枚举类内容，供其他方法更便捷高效的实现
     * @param type 配置文件中设置的转换类
     */
    public EnumSubjectHandler(Class<Subject> type) {
        if (type == null)
            throw new IllegalArgumentException("Type argument cannot be null");
    }

    /**
     * 用于定义设置参数时，该如何把Java类型的参数转换为对应的数据库类型
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Subject parameter, JdbcType jdbcType) throws SQLException {
        // 根据数据库存储类型决定获取类型，本例子中数据库中存放int类型
        // ps.setString
        ps.setInt(i, parameter.getId());
    }

    /**
     * 用于定义通过字段名称获取字段数据时，如何把数据库类型转换为对应的Java类型
     */
    @Override
    public Subject getNullableResult(ResultSet rs, String columnName) throws SQLException {
        // 根据数据库存储类型决定获取类型，本例子中数据库中存放int类型
        // String i = rs.getString(columnName);
        int i = rs.getInt(columnName);
        if (rs.wasNull()) {
            return null;
        } else {
            // 根据数据库中的值，定位Enum子类
            return locateEnum(i);
        }
    }

    /**
     * 用于定义通过字段索引获取字段数据时，如何把数据库类型转换为对应的Java类型
     * @param rs
     * @param columnIndex
     * @return
     * @throws SQLException
     */
    @Override
    public Subject getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        // 根据数据库存储类型决定获取类型，本例子中数据库中存放int类型
        // String i = rs.getString(columnIndex);
        int i = rs.getInt(columnIndex);
        if (rs.wasNull()) {
            return null;
        } else {
            // 根据数据库中的值，定位Enum子类
            return locateEnum(i);
        }
    }

    /**
     * 用定义调用存储过程后，如何把数据库类型转换为对应的Java类型
     * @param cs
     * @param columnIndex
     * @return
     * @throws SQLException
     */
    @Override
    public Subject getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        // 根据数据库存储类型决定获取类型，本例子中数据库中存放int类型
        // String i = cs.getString(columnIndex);
        int i = cs.getInt(columnIndex);
        if (cs.wasNull()) {
            return null;
        } else {
            // 根据数据库中的值，定位Enum子类
            return locateEnum(i);
        }
    }

    /**
     * 枚举类型转换
     * @param value 数据库中存储的自定义属性
     * @return value对应的枚举类
     */
    private Subject locateEnum(int value) {
        for (Subject status : Subject.values()) {
            if (status.getId() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("未知的枚举类型：" + value);
    }
}
