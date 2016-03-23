package com.ft9.util;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import com.ft9.view.NameConverter;

public class ViewUtil {
	public static <T>DefaultTableModel transferBeanList2DefaultTableModel(List<T>beanList,String functionName){
		DefaultTableModel dtModel=new DefaultTableModel();
		String[] columnNameArr= NameConverter.getTitleArr(functionName);
		dtModel.setColumnIdentifiers(columnNameArr);
		for(int i=0;i<beanList.size();++i){
			Map<String,String>map=BeanUtil.transBean2Map(beanList.get(i));
			List<String> rowList=new ArrayList<String>();
			for(String columnName:columnNameArr){
				String physicName=NameConverter.convertViewName2PhysicName(functionName, columnName);
				rowList.add(map.get(physicName));
			}
			dtModel.addRow(rowList.toArray());
		}
		return dtModel;
	}
	
	public static DefaultTableModel transferMapListToDTModel(List<String>header,List<HashMap<String,String>>datas){
		DefaultTableModel dtModel=new DefaultTableModel();
		Object[] columnNameArr= header.toArray();
		dtModel.setColumnIdentifiers(columnNameArr);
		for(int i=0;i<datas.size();++i){
			Map<String,String>map=datas.get(i);
			List<String> rowList=new ArrayList<String>();
			for(Object columnName:columnNameArr){
				rowList.add(map.get(columnName.toString()));
			}
			dtModel.addRow(rowList.toArray());
		}
		return dtModel;
	}
	public static JTable createUneditableTable(){
		JTable jTable=new JTable(){
			private static final long serialVersionUID = 4998323002110009801L;

			public boolean isCellEditable(int row, int column) { 
			    return false;
			 }
		};
		return jTable;
	}
	
	public static List<String>getRowDataListFromTable(JTable table,int rowIndex){
		int columnNum=table.getColumnCount();
		List<String> rowData=new ArrayList<String>();
		for(int i=0;i<columnNum;++i){
			rowData.add(table.getValueAt(rowIndex, i).toString());
		}
		return rowData;
	}
	
	public static List<HashMap<String,String>>getSelectedData(JTable jTable){
		List<HashMap<String,String>>selectedData=new ArrayList<HashMap<String,String>>();
		int []rowIndexs=jTable.getSelectedRows();
		List<String>tableHeaderList=new ArrayList<String>();
		for(int i=0;i<((DefaultTableModel)jTable.getModel()).getColumnCount();++i){
			tableHeaderList.add(((DefaultTableModel)jTable.getModel()).getColumnName(i));
		}
		//Object[]tableHeader=null;
		for(int rowIndex:rowIndexs){
			HashMap<String,String>map=new HashMap<String,String>();
			List<String>rowDataList=getRowDataListFromTable(jTable, rowIndex);
			for(int columnIndex=0;columnIndex<tableHeaderList.size();++columnIndex){
				String key=tableHeaderList.get(columnIndex).toString();
				String value=rowDataList.get(columnIndex);
				map.put(key, value);
			}
			selectedData.add(map);
		}
		return selectedData;
	}
	
	public static boolean isJTextEmpty(JTextComponent jText){
		return jText==null||jText.getText()==null||jText.getText().equals("");
	}
	public static void setJTextError(JTextComponent jText){
		jText.setBackground(new Color(253,13,53));
		jText.setCaretColor(Color.WHITE);
	}
	
	public static void clearJTextError(JTextComponent jText){
		jText.setBackground(Color.white);
		jText.setCaretColor(Color.BLACK);
	}
}
