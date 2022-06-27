package com.cgb.utils;

import com.cgb.pojo.BaseEnum;
import com.cgb.pojo.Subject;
import com.cgb.pojo.TopicType;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(value = {Subject.class,TopicType.class})
public class EnumTypeHandler extends BaseTypeHandler<BaseEnum> {

    private Class<BaseEnum> type;

    public EnumTypeHandler() {
    }

    public EnumTypeHandler(Class<BaseEnum> type) {
        if (type == null) throw new IllegalArgumentException("Type argument cannot be null");
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, BaseEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getValue());
    }

    @Override
    public BaseEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int i = rs.getInt(columnName);
        if (rs.wasNull()) {
            return null;
        } else {
            // 根据数据库中的值，定位Enum子类
            return locateEnum(i);
        }
    }

    @Override
    public BaseEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int i = rs.getInt(columnIndex);
        if (rs.wasNull()) {
            return null;
        } else {
            // 根据数据库中的值，定位Enum子类
            return locateEnum(i);
        }
    }

    @Override
    public BaseEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int i = cs.getInt(columnIndex);
        if (cs.wasNull()) {
            return null;
        } else {
            // 根据数据库中的值，定位Enum子类
            return locateEnum(i);
        }
    }

    private BaseEnum  locateEnum(int value) {
//        System.out.println(value);
//        for (Subject status : Subject.values()) {
//            if (status.getId() == value) {
//                return status;
//            }
//        }
        BaseEnum[] objs = type.getEnumConstants();
        for (BaseEnum em : objs) {
            if (em.getValue() == value) {
                return em;
            }
        }
        throw new IllegalArgumentException("未知的枚举类型：" + value);
    }
}
