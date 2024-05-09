package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @TableName bridge
 */
@TableName(value ="bridge")
@Data
public class BridgeInfo implements Serializable {
    /**
     *
     */
    @TableId(value = "bridge_id")
    private Integer bridgeId;

    /**
     *
     */
    @TableField(value = "bridge_name")
    private String bridgeName;

    /**
     *
     */
    @TableField(value = "bridge_address")
    private String bridgeAddress;

    /**
     *
     */
    @TableField(value = "create_date")
    private LocalDate createDate;

    /**
     *
     */
    @TableField(value = "bridge_type")
    private Integer bridgeType;

    /**
     *
     */
    @TableField(value = "bridge_length")
    private Double bridgeLength;

    /**
     *
     */
    @TableField(value = "bridge_width")
    private Double bridgeWidth;

    /**
     * 设计寿命
     */
    @TableField(value = "design_life")
    private String designLife;

    /**
     * 设计载荷
     */
    @TableField(value = "design_load")
    private String designLoad;

    /**
     * 直属巡检员
     */
    @TableField(value = "direct_inspector")
    private String directInspector;

    /**
     * 桥梁类型
     */
    @TableField(exist = false)
    private String bridgeTypeName;
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBridgeId() == null) ? 0 : getBridgeId().hashCode());
        result = prime * result + ((getBridgeName() == null) ? 0 : getBridgeName().hashCode());
        result = prime * result + ((getBridgeAddress() == null) ? 0 : getBridgeAddress().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getBridgeType() == null) ? 0 : getBridgeType().hashCode());
        result = prime * result + ((getBridgeLength() == null) ? 0 : getBridgeLength().hashCode());
        result = prime * result + ((getBridgeWidth() == null) ? 0 : getBridgeWidth().hashCode());
        result = prime * result + ((getDesignLife() == null) ? 0 : getDesignLife().hashCode());
        result = prime * result + ((getDesignLoad() == null) ? 0 : getDesignLoad().hashCode());
        result = prime * result + ((getDirectInspector() == null) ? 0 : getDirectInspector().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bridgeId=").append(bridgeId);
        sb.append(", bridgeName=").append(bridgeName);
        sb.append(", bridgeAddress=").append(bridgeAddress);
        sb.append(", createDate=").append(createDate);
        sb.append(", bridgeType=").append(bridgeType);
        sb.append(", bridgeLength=").append(bridgeLength);
        sb.append(", bridgeWidth=").append(bridgeWidth);
        sb.append(", designLife=").append(designLife);
        sb.append(", designLoad=").append(designLoad);
        sb.append(", directInspector=").append(directInspector);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }


    public  String getName() {
        return this.bridgeName;
    }

    public Integer  getId() {
        return this.bridgeId;
    }
}
