package pe.org.pub.eess.poe.form;
 
import java.math.BigDecimal;

import org.springframework.web.multipart.commons.CommonsMultipartFile;
 
public class ProductInfo {
    private String code;
    private String name;
    private BigDecimal price;
 
    private boolean newProduct=false;
 
    // Upload file.
    private CommonsMultipartFile fileData;
 
    public ProductInfo() {
    }
 
//    public ProductInfo(Product product) {
//        this.code = product.getCode();
//        this.name = product.getName();
//        this.price = product.getPrice();
//    }
 
    // Khooong thay doi Constructor 
    //  dung trong Hibernate query.
    public ProductInfo(String code, String name, BigDecimal price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }
 
    public String getCode() {
        return code;
    }
 
    public void setCode(String code) {
        this.code = code;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public BigDecimal getPrice() {
        return price;
    }
 
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
 
    public CommonsMultipartFile getFileData() {
        return fileData;
    }
 
    public void setFileData(CommonsMultipartFile fileData) {
        this.fileData = fileData;
    }
 
    public boolean isNewProduct() {
        return newProduct;
    }
 
    public void setNewProduct(boolean newProduct) {
        this.newProduct = newProduct;
    }
 
}
