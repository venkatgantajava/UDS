package com.ecrops.masters;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="farmer_grp_map_t",schema = "farmmechanization")
public class FarmerGrpmap {

	
	        @Id
	    	@GeneratedValue(strategy = GenerationType.IDENTITY)
            private	int id;
	       @Column(name="rskcode")
	        private String rskcode;
	      @Column(name="vcode")

	        private int vcode;
         	@Column(name="grp_id")

	        private String grp_id;
	       @Column(name="farmer_id")

	        private String farmer_id;
	        @Column(name="farmer_grp_type")

	        private char farmer_grp_type;
	        @Column(name="cropyear")
	        private int cropyear;

public FarmerGrpmap() {
	// TODO Auto-generated constructor stub
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getRskcode() {
	return rskcode;
}

public void setRskcode(String rskcode) {
	this.rskcode = rskcode;
}

public int getVcode() {
	return vcode;
}

public void setVcode(int vcode) {
	this.vcode = vcode;
}

public String getGrp_id() {
	return grp_id;
}

public void setGrp_id(String grp_id) {
	this.grp_id = grp_id;
}

public String getFarmer_id() {
	return farmer_id;
}

public void setFarmer_id(String farmer_id) {
	this.farmer_id = farmer_id;
}

public char getFarmer_grp_type() {
	return farmer_grp_type;
}

public void setFarmer_grp_type(char farmer_grp_type) {
	this.farmer_grp_type = farmer_grp_type;
}

public int getCropyear() {
	return cropyear;
}

public void setCropyear(int cropyear) {
	this.cropyear = cropyear;
}

@Override
public String toString() {
	return "FarmerGrpmap [id=" + id + ", rskcode=" + rskcode + ", vcode=" + vcode + ", grp_id=" + grp_id
			+ ", farmer_id=" + farmer_id + ", farmer_grp_type=" + farmer_grp_type + ", cropyear=" + cropyear + "]";
}

	        
	
	
}
