package com.cx.pojo;

/**
 * 品牌
 */

/**
 * 快捷键: Ctrl + R         可以自定义替换某一个字段或者符号
 * 快捷键: Alt + 鼠标左键   整列编辑  可以自定义选择一块(一列)区域，进行输入，修改等操作
 *
 * 在实体类中,基本数据类型推荐使用包装类,比如 int用 Integer
 */
public class Brand {

    private Integer id;               // 主键
    private String brandName;       // 品牌名称
    private String companyName;     // 企业名称
    private Integer ordered;          // 排序字段
    private String description;      // 描述信息
    private Integer status;           // 状态：0: 禁用  1:启用

    public Brand() {
    }

    //逻辑视图
    public String getStatusStr(){
        if(this.status==1){
            return "启用";
        }
        return "禁用";
    }

    public Brand(Integer id, String brandName, String companyName, Integer ordered, String description, Integer status) {
        this.id = id;
        this.brandName = brandName;
        this.companyName = companyName;
        this.ordered = ordered;
        this.description = description;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", ordered=" + ordered +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}

