package com.model2.mvc.service.purchase.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.model2.mvc.common.Search;
import com.model2.mvc.common.util.DBUtil;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.purchase.vo.PurchaseVO;
import com.model2.mvc.service.domain.User;

public class PurchaseDAO {

	public PurchaseDAO(){
		
	}
	
	public void insertPurchase(PurchaseVO purchaseVO)throws Exception{
		Connection con = DBUtil.getConnection();
		
		String sql ="insert into transaction "+
					"values(seq_transaction_tran_no.nextval,?,?,?,?,?,?,?,1,sysdate,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		int prodNo = purchaseVO.getPurchaseProd().getProdNo();
		stmt.setInt(1, prodNo);
		String userId = purchaseVO.getBuyer().getUserId();
		stmt.setString(2, userId);
		stmt.setString(3, purchaseVO.getPaymentOption());
		stmt.setString(4, purchaseVO.getReceiverName());
		stmt.setString(5, purchaseVO.getReceiverPhone());
		stmt.setString(6, purchaseVO.getDivyAddr());
		stmt.setString(7, purchaseVO.getDivyRequest());
		stmt.setString(8, purchaseVO.getDivyDate());
		stmt.executeUpdate();
		
		System.out.println(sql);
		con.close();

		
	}
	
	public void updatePurchase(PurchaseVO purchaseVO) throws Exception{
		Connection con = DBUtil.getConnection();
		String sql = "update transaction set payment_option=?, "+
						"receiver_name=?,receiver_phone=?,"+
						"demailAddr=?,dlvy_request=?,"+
						"dlvy_date=? where tran_no=?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, purchaseVO.getPaymentOption());
		stmt.setString(2, purchaseVO.getReceiverName());
		stmt.setString(3, purchaseVO.getReceiverPhone());
		stmt.setString(4, purchaseVO.getDivyAddr());
		stmt.setString(5, purchaseVO.getDivyRequest());
		stmt.setString(6, purchaseVO.getDivyDate());
		stmt.setInt(7, purchaseVO.getTranNo());
		stmt.executeUpdate();
		con.close();
	}

	public PurchaseVO findPurchase(int tranNo) throws Exception{
		
		Connection con = DBUtil.getConnection();
		
		String sql ="select * from transaction where tran_no=?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, tranNo);
		
		ResultSet rs = stmt.executeQuery();
		PurchaseVO purchaseVO = new PurchaseVO();
		while (rs.next()) {
			
			ProductVO prodVO = new ProductVO();
			User userVO = new User();
			purchaseVO = new PurchaseVO();
			
			prodVO.setProdNo(rs.getInt("prod_No"));
			userVO.setUserId(rs.getString("buyer_id"));
			
			purchaseVO.setTranNo(rs.getInt("tran_No"));
			purchaseVO.setPurchaseProd(prodVO);;
			purchaseVO.setBuyer(userVO);;
			purchaseVO.setPaymentOption(rs.getString("payment_Option"));
			purchaseVO.setReceiverName(rs.getString("receiver_Name"));
			purchaseVO.setReceiverPhone(rs.getString("receiver_Phone"));
			purchaseVO.setDivyAddr(rs.getString("demailAddr"));
			purchaseVO.setDivyRequest(rs.getString("dlvy_Request"));
			purchaseVO.setTranCode(rs.getString("tran_status_code"));
			purchaseVO.setOrderDate(rs.getDate("order_data"));
			purchaseVO.setDivyDate(rs.getString("dlvy_Date"));
		}
		
		con.close();
		
		return purchaseVO;
	}
	
	public PurchaseVO findPurchase2(int prodNo) throws Exception{
		
		Connection con = DBUtil.getConnection();
		
		String sql ="select * from transaction where prod_no=?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, prodNo);
		
		ResultSet rs = stmt.executeQuery();
		PurchaseVO purchaseVO = new PurchaseVO();
		while (rs.next()) {
			
			ProductVO prodVO = new ProductVO();
			User userVO = new User();
			purchaseVO = new PurchaseVO();
			
			prodVO.setProdNo(rs.getInt("prod_No"));
			userVO.setUserId(rs.getString("buyer_id"));
			
			purchaseVO.setTranNo(rs.getInt("tran_No"));
			purchaseVO.setPurchaseProd(prodVO);;
			purchaseVO.setBuyer(userVO);;
			purchaseVO.setPaymentOption(rs.getString("payment_Option"));
			purchaseVO.setReceiverName(rs.getString("receiver_Name"));
			purchaseVO.setReceiverPhone(rs.getString("receiver_Phone"));
			purchaseVO.setDivyAddr(rs.getString("demailAddr"));
			purchaseVO.setDivyRequest(rs.getString("dlvy_Request"));
			purchaseVO.setTranCode(rs.getString("tran_status_code"));
			purchaseVO.setOrderDate(rs.getDate("order_data"));
			purchaseVO.setDivyDate(rs.getString("dlvy_Date"));
		}
		
		con.close();
		
		return purchaseVO;
	}
public HashMap<String,Object> getPurchaseList(Search searchVO,String buyerId) throws Exception {
		
		Connection con = DBUtil.getConnection();
		
		String sql = "select * from transaction where buyer_id=? order by prod_no";
		
		PreparedStatement stmt =
				con.prepareStatement(sql,
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
		stmt.setString(1, buyerId);
		ResultSet rs = stmt.executeQuery();
		
		rs.last();
		int total = rs.getRow();
		
		System.out.println("로우의 수:" + total);

		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("count", new Integer(total));

		rs.absolute(searchVO.getPage() * searchVO.getPageUnit() - searchVO.getPageUnit()+1);
		System.out.println("searchVO.getPage():" + searchVO.getPage());
		System.out.println("searchVO.getPageUnit():" + searchVO.getPageUnit());

		ArrayList<PurchaseVO> list = new ArrayList<PurchaseVO>();
		if (total > 0) {
			for (int i = 0; i < searchVO.getPageUnit(); i++) {
				PurchaseVO vo = new PurchaseVO();
				User userVO = new User();
				userVO.setUserId(rs.getString("buyer_id"));
				vo.setBuyer(userVO);
				vo.setTranNo(rs.getInt("tran_No"));
				vo.setReceiverName(rs.getString("receiver_Name"));
				vo.setReceiverPhone(rs.getString("receiver_Phone"));
				vo.setTranCode(rs.getString("tran_status_Code"));
				list.add(vo);
				if(!rs.next())
					break;
				}
			}
		
		System.out.println("list.size() : "+ list.size());
		map.put("list", list);
		System.out.println("map().size() : "+ map.size());
		
		con.close();
		
		return map;
		
	}

	public void updateTranCode(PurchaseVO purchaseVO) throws Exception{
	Connection con = DBUtil.getConnection();
	String sql = "update transaction "+
				"set tran_status_code=? "+
				"where tran_no=?";
	
	PreparedStatement stmt = con.prepareStatement(sql);
	stmt.setString(1, purchaseVO.getTranCode());
	stmt.setInt(2, purchaseVO.getTranNo());
	System.out.println(purchaseVO.getTranCode());
	stmt.executeUpdate();
	con.close();
	
	}

}
