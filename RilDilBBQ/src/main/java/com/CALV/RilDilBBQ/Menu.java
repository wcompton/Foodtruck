package com.CALV.RilDilBBQ;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.lang.Double;
//import java.util.Date;
import java.io.Serializable;

@Entity
@Table(name = "menus")
@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
//      allowGetters = true)
public class Menu implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String menuItem;
  
  @NotNull
  private Double itemPrice;

  @NotBlank
  private String description;
  
  @NotBlank
  private String image;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(String menuItem) {
		this.menuItem = menuItem;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", menuItem=" + menuItem + ", itemPrice=" + itemPrice + ", description=" + description
				+ ", image=" + image + "]";
	}

  // Getters and Setters ... (Omitted for brevity)
  
}