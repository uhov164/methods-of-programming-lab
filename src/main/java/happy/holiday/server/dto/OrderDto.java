package happy.holiday.server.dto;

import java.util.Date;

import lombok.Data;

@Data
public class OrderDto {
	private String userPhoneNumber; 
	private String sellerPhoneNumber; 
	private ItemDto item;

	private Date date;
}
