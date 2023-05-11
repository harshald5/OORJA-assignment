package com.oorjaa.ShopApp.Model;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;


//**************REDUNTANT MODEL CLASS********************


@Data

public class OfferComposite implements Serializable {
	
	private int offerId;
	private int custId; 

}

