package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @TableName bridgedisease
 */
@TableName(value ="bridgedisease")
@Data
public class BridgeDisease implements Serializable {
    /**
     *
     */
    @TableField(value = "bridge_id")
    private String bridgeId;

    /**
     *
     */

    @TableId(value = "disease_id")
    private String diseaseId;

    /**
     *
     */
    @TableField(value = "disease_type")
    private Integer diseaseType;

    /**
     *
     */
    @TableField(value = "disease_level")
    private Integer diseaseLevel;
    /**
     *
     */
    @TableField(value = "disease_length")
    private String diseaseLength;
    /**
     *
     */
    @TableField(value = "disease_area")
    private String diseaseArea;

    /**
     *
     */
    @TableField(value = "disease_time")
    private LocalDateTime diseaseTime;

    @TableField(exist = false)
    private String diseaseName;

    @TableField(exist = false)
    private String bridgeName;

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
        BridgeDisease other = (BridgeDisease) that;
        return (this.getBridgeId() == null ? other.getBridgeId() == null : this.getBridgeId().equals(other.getBridgeId()))
            && (this.getDiseaseId() == null ? other.getDiseaseId() == null : this.getDiseaseId().equals(other.getDiseaseId()))
            && (this.getDiseaseType() == null ? other.getDiseaseType() == null : this.getDiseaseType().equals(other.getDiseaseType()))
            && (this.getDiseaseLevel() == null ? other.getDiseaseLevel() == null : this.getDiseaseLevel().equals(other.getDiseaseLevel()))
            && (this.getDiseaseArea() == null ? other.getDiseaseArea() == null : this.getDiseaseArea().equals(other.getDiseaseArea()))
            && (this.getDiseaseTime() == null ? other.getDiseaseTime() == null : this.getDiseaseTime().equals(other.getDiseaseTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBridgeId() == null) ? 0 : getBridgeId().hashCode());
        result = prime * result + ((getDiseaseId() == null) ? 0 : getDiseaseId().hashCode());
        result = prime * result + ((getDiseaseType() == null) ? 0 : getDiseaseType().hashCode());
        result = prime * result + ((getDiseaseLevel() == null) ? 0 : getDiseaseLevel().hashCode());
        result = prime * result + ((getDiseaseArea() == null) ? 0 : getDiseaseArea().hashCode());
        result = prime * result + ((getDiseaseTime() == null) ? 0 : getDiseaseTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bridgeId=").append(bridgeId);
        sb.append(", diseaseId=").append(diseaseId);
        sb.append(", diseaseType=").append(diseaseType);
        sb.append(", diseaseLevel=").append(diseaseLevel);
        sb.append(", diseaseArea=").append(diseaseArea);
        sb.append(", diseaseTime=").append(diseaseTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
