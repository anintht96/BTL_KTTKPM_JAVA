package model;

import java.util.ArrayList;
import java.util.List;

public class CartBean {

	private double tongTien;
	private List<CartItem> listAllCartItem = new ArrayList<CartItem>();

	public int getLineItemCount() {
		return listAllCartItem.size();
	}
	
	public CartBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public List<CartItem> getListAllCartItem() {
		return listAllCartItem;
	}

	public void setListAllCartItem(List<CartItem> listAllCartItem) {
		this.listAllCartItem = listAllCartItem;
	}

	public void calculateTongTien() {
		double dbTongTien = 0.0;
		for (int counter = 0; counter < listAllCartItem.size(); counter++) {
			CartItem cartItem = listAllCartItem.get(counter);
			dbTongTien += cartItem.getThanhTien();
		}
		setTongTien(dbTongTien);
	}

	public void deleteCartItem(int itemIndex) {
		try {
			listAllCartItem.remove(itemIndex - 1);
			calculateTongTien();
		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Error while delete cart item:" + e.getMessage());
			e.printStackTrace();
		}
	}

	public void updateCartItem(int itemIndex, int soLuong) {
		double dbThanhTien = 0.0;
		double dbDonGia = 0.0;
		CartItem cartItem = null;
		try {
			if (soLuong > 0) {
				cartItem = listAllCartItem.get(itemIndex - 1);
				dbDonGia = cartItem.getDonGia();
				dbThanhTien = soLuong * dbDonGia;
				cartItem.setSoLuong(soLuong);
				cartItem.setThanhTien(dbThanhTien);
				calculateTongTien();
			}
		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Error while update cart item:" + e.getMessage());
			e.printStackTrace();
		}
	}

	public CartItem getCartItem(int itemIndex) {
		CartItem cartItem = null;
		if (listAllCartItem.size() > itemIndex) {
			cartItem = listAllCartItem.get(itemIndex);
		}
		return cartItem;
	}

	public void addCartItem(String strThongTin, String modelNo, String strSoLuong, String strDonGia) {
		double dbThaTien = 0.0;
		double dbDonGia = 0.0;
		int soLuong;
		CartItem cartItem = new CartItem();
		try {
			dbDonGia = Double.parseDouble(strDonGia);
			soLuong = Integer.parseInt(strSoLuong);
			if (soLuong > 0) {
				dbThaTien = dbDonGia * soLuong;
				cartItem.setPartNumber(modelNo);
				cartItem.setThongTin(strThongTin);
				cartItem.setDonGia(dbDonGia);
				cartItem.setSoLuong(soLuong);
				cartItem.setThanhTien(dbThaTien);
				listAllCartItem.add(cartItem);
				calculateTongTien();
			}
		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Error while adding cart item:" + e.getMessage());
			e.printStackTrace();
		}
	}

	public void addCartItem(CartItem cartItem) {
		listAllCartItem.add(cartItem);
		calculateTongTien();
	}

	@Override
	public String toString() {
		return "CartBean [tongTien=" + tongTien + ", listAllCartItem=" + listAllCartItem + "]";
	}
	
	
}
