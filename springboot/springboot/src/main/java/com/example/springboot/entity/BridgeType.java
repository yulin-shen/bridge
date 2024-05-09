package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * @TableName bridge_type
 */
@TableName(value ="bridge_type")
@Data
public class BridgeType implements Serializable {
    /**
     *
     */
    @TableId(value = "bridge_type_id")
    private Integer bridgeTypeId;

    /**
     *
     */
    @TableField(value = "bridge_type_name")
    private String bridgeTypeName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BridgeType other = (BridgeType) that;
        return (this.getBridgeTypeId() == null ? other.getBridgeTypeId() == null : this.getBridgeTypeId().equals(other.getBridgeTypeId()))
            && (this.getBridgeTypeName() == null ? other.getBridgeTypeName() == null : this.getBridgeTypeName().equals(other.getBridgeTypeName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBridgeTypeId() == null) ? 0 : getBridgeTypeId().hashCode());
        result = prime * result + ((getBridgeTypeName() == null) ? 0 : getBridgeTypeName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bridgeTypeId=").append(bridgeTypeId);
        sb.append(", bridgeTypeName=").append(bridgeTypeName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
