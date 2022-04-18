package generator.domain;

import java.io.Serializable;

/**
 * 
 * @TableName tb_brand
 */
public class TbBrand implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String brandName;

    /**
     * 
     */
    private String companyName;

    /**
     * 
     */
    private Integer ordered;

    /**
     * 
     */
    private String description;

    /**
     * 
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * 
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * 
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 
     */
    public Integer getOrdered() {
        return ordered;
    }

    /**
     * 
     */
    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    /**
     * 
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

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
        TbBrand other = (TbBrand) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBrandName() == null ? other.getBrandName() == null : this.getBrandName().equals(other.getBrandName()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getOrdered() == null ? other.getOrdered() == null : this.getOrdered().equals(other.getOrdered()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBrandName() == null) ? 0 : getBrandName().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getOrdered() == null) ? 0 : getOrdered().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", brandName=").append(brandName);
        sb.append(", companyName=").append(companyName);
        sb.append(", ordered=").append(ordered);
        sb.append(", description=").append(description);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}