package logic;

import java.sql.Date;

public class Client 
{
	private int cliente_id;
	private int vip_lv_id;
	private int residence_sector;
	private int birth_sector;
	private String name;
	private Date birth_date;
	private String Sex;
	private String last_name;
	
	
	
	public Client(int cliente_id, int vip_lv_id, int residence_sector,
			int birth_sector, String name, Date birth_date, String sex,
			String last_name) 
	{
		super();
		this.cliente_id = cliente_id;
		this.vip_lv_id = vip_lv_id;
		this.residence_sector = residence_sector;
		this.birth_sector = birth_sector;
		this.name = name;
		this.birth_date = birth_date;
		this.Sex = sex;
		this.last_name = last_name;
	}
	public int getCliente_id() {
		return cliente_id;
	}
	public int getVip_lv_id() {
		return vip_lv_id;
	}
	public int getResidence_sector() {
		return residence_sector;
	}
	public int getBirth_sector() {
		return birth_sector;
	}
	public String getName() {
		return name;
	}
	public Date getBirth_date() {
		return birth_date;
	}
	public String getSex() {
		return Sex;
	}
	public String getLast_name() {
		return last_name;
	}

	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}
	public void setVip_lv_id(int vip_lv_id) {
		this.vip_lv_id = vip_lv_id;
	}
	public void setResidence_sector(int residence_sector) {
		this.residence_sector = residence_sector;
	}
	public void setBirth_sector(int birth_sector) {
		this.birth_sector = birth_sector;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	public void setSex(String sex) {
		this.Sex = sex;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
}
