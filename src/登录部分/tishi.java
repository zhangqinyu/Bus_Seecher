package 登录部分;
/*
 * 这是下拉框提示
 */
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class  tishi{
	private Connection conn = null;
	private Statement stmt=null;
	private ResultSet rs=null;
	ArrayList<String> items=new ArrayList<String>();
    public tishi(JTextField jt,String sql){
   	 
   	 try {
			show_tishi( jt,sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	   private void show_tishi(JTextField jt,String sql) throws Exception 
	    
	    {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost/mydata?"
						+ "user=root&password=root");
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				//items.clear();
				while (rs.next()) {
					items.add(rs.getString(1));
					System.out.println(rs.getString(1));
				}
				
	        setupAutoComplete(jt, items);
	        jt.setColumns(30);
	    }

	    private boolean isAdjusting(JComboBox cbInput) {
	        if (cbInput.getClientProperty("is_adjusting") instanceof Boolean) {
	            return (Boolean) cbInput.getClientProperty("is_adjusting");
	        }
	        return false;
	    }

	    private void setAdjusting(JComboBox cbInput, boolean adjusting) {
	        cbInput.putClientProperty("is_adjusting", adjusting);
	    }
	    
	   

	    public void setupAutoComplete(final JTextField txtInput, final ArrayList<String> items) {
	    	
	    	//items.clear();
	    	final DefaultComboBoxModel model = new DefaultComboBoxModel();
	         final JComboBox cbInput = new JComboBox(model) {
	            public Dimension getPreferredSize() {
	                return new Dimension(super.getPreferredSize().width, 0);
	            }
	        };
	        setAdjusting(cbInput, false);
	        for (String item : items) {
	            model.addElement(item);
	        }
	        cbInput.setSelectedItem(null);
	        cbInput.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                if (!isAdjusting(cbInput)) {
	                    if (cbInput.getSelectedItem() != null) {
	                        txtInput.setText(cbInput.getSelectedItem().toString());
	                    }
	                }
	            }
	        });
	       //model.removeAllElements();
	        cbInput.setRenderer(new DefaultListCellRenderer(){
	        	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	        		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
	        		if(value != null){
	        			this.setText(value.toString());
	        			String url = value.toString().replaceAll(" ", "_") + ".png";
	        			
	        		}
	        		return this;
	        	}
	        });

	        txtInput.addKeyListener(new KeyAdapter() {

	            @Override
	            public void keyPressed(KeyEvent e) {
	                setAdjusting(cbInput, true);
	                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
	                    if (cbInput.isPopupVisible()) {
	                        e.setKeyCode(KeyEvent.VK_ENTER);
	                    }
	                }
	                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
	                    e.setSource(cbInput);
	                    cbInput.dispatchEvent(e);
	                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	                    	txtInput.setText(cbInput.getSelectedItem().toString());
	                        cbInput.setPopupVisible(false);
	                    }
	                }
	                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
	                    cbInput.setPopupVisible(false);
	                }
	                setAdjusting(cbInput, false);
	            }
	        });
	        txtInput.getDocument().addDocumentListener(new DocumentListener() {
	            public void insertUpdate(DocumentEvent e) {
	                updateList();
	            }

	            public void removeUpdate(DocumentEvent e) {
	                updateList();
	            }

	            public void changedUpdate(DocumentEvent e) {
	                updateList();
	            }

	            private void updateList() {
	                setAdjusting(cbInput, true);
	                model.removeAllElements();
	                String input = txtInput.getText();
	                if (!input.isEmpty()) {
	                    for (String item : items) {
	                        if (item.toLowerCase().contains(input.toLowerCase())) {
	                        	//判断字符串；
	                            model.addElement(item);
	                        }
	                    }
	                }
	                cbInput.hidePopup();
	                cbInput.setPopupVisible(model.getSize() > 0);
	                setAdjusting(cbInput, false);
	            }
	        });
	        txtInput.setLayout(new BorderLayout());
	        txtInput.add(cbInput, BorderLayout.SOUTH);
	    }
	
  }