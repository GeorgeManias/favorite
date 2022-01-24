package favorite;

import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.NumberFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class favoriteMain {

	favoriteMain() {
		final JFrame frmFavorites = new JFrame();
		frmFavorites.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFavorites.setTitle("My Favorites");
		frmFavorites.getContentPane().setLayout(null);//It is important to remember that in order make a free GUI the layout should be null
		frmFavorites.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmFavorites.setLocationRelativeTo(null);
		Border border = BorderFactory.createLineBorder(null, 5);
		
		//TitleLabel Start//
		final JLabel titler = new JLabel("My Favorite Project");
		titler.setVerticalAlignment(JLabel.TOP);
		titler.setHorizontalAlignment(JLabel.CENTER);
		titler.setBorder(null);
		titler.setBounds(435,30,400,50);
		titler.setFont(new Font("Calibri", Font.BOLD, 40));
		//titler.setBorder(border);
		
		//TitleLabel END//
		
		//Category(LoV), Creation Date, Modification Date, Rank(1,10), Title, DataSubjectANum, DataSubjectBText, DateOfRelease.

		final JLabel categoryF = new JLabel("Category:");
		//categoryF.setBorder(border);
		
		
		final JLabel creationD = new JLabel("Creation Date:");
		final JLabel modificationD = new JLabel("Modification Date:");
		final JLabel rankLoV = new JLabel("My Rank:");
		final JLabel comment1 = new JLabel("Rec Comment 1:");
		final JLabel comment2 = new JLabel("Rec Comment 2:");
		final JLabel dateOfRelease = new JLabel("Release Date:");// Calendar
		
		final JButton searchButton = new JButton("Search");
		final JButton addButton = new JButton("Add Record");
		final JButton editButton = new JButton("Edit Record");
		final JButton addNewCateg = new JButton("New Category");
		
		categoryF.setFont(new Font("Calibri", Font.PLAIN, 20));
		categoryF.setBounds(80,210,200,30);
		
		creationD.setFont(new Font("Calibri", Font.PLAIN, 20));
		creationD.setBounds(80,240,200,30);
		
		modificationD.setFont(new Font("Calibri", Font.PLAIN, 20));
		modificationD.setBounds(80,270,200,30);
		
		rankLoV.setFont(new Font("Calibri", Font.PLAIN, 20));
		rankLoV.setBounds(80,300,200,30);
		
		comment1.setFont(new Font("Calibri", Font.PLAIN, 20));
		comment1.setBounds(580,210,200,30);
		
		comment2.setFont(new Font("Calibri", Font.PLAIN, 20));
		comment2.setBounds(580,240,200,30);	
		
		dateOfRelease.setFont(new Font("Calibri", Font.PLAIN, 20));
		dateOfRelease.setBounds(580,270,200,30);	
		
		
		
		searchButton.setFont(new Font("Calibri", Font.BOLD, 20));
		searchButton.setBounds(1050,210,150,25);
		
		addButton.setFont(new Font("Calibri", Font.BOLD, 20));
		addButton.setBounds(1050,240,150,25);
		
		editButton.setFont(new Font("Calibri", Font.BOLD, 20));
		editButton.setBounds(1050,270,150,25);
		
		addNewCateg.setFont(new Font("Calibri", Font.BOLD, 20));
		addNewCateg.setBounds(1025,340,180,28);
		/////////////////////////////////////
		JComboBox categoryList = new JComboBox();
		JComboBox RankList = new JComboBox();
		
		DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		JFormattedTextField dateTextFieldCreation = new JFormattedTextField(dateformat);
		JFormattedTextField dateTextFieldModified = new JFormattedTextField(dateformat);
		JFormattedTextField dateTextFieldTRelease = new JFormattedTextField(dateformat);
		/*
		NumberFormatter  numericFormat = new NumberFormatter();
		numericFormat.setValueClass(Long.class);
		numericFormat.setAllowsInvalid(true);
		JFormattedTextField comment1Input = new JFormattedTextField(numericFormat);
		*/
		JTextField comment1Input = new JTextField();
		JTextField characterCommentInput = new JTextField();
		
		/////////////////////////////////////
		  String[] columnNames = {"Category", "Creation Date", "Modification Date", "My Rank","Rec Comment 1","Rec Comment 2", "Release Date"};
	        Object[][] data =
	        {
	            {"backIcon", "BACllllllllllllllllllllK"},
	            {"exitIcon", "EXIT"},
	            {"forwardIcon", "FORWARD"},
	        };
	        DefaultTableModel model = new DefaultTableModel(data, columnNames);
	        

		/////////////////////////////////////
		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(80,400, 1130, 320);
		frmFavorites.getContentPane().add(scrollPane);
		
		scrollPane.setViewportView(table);
		
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Dialog", Font.BOLD, 18));
		
		
		
		
		
		/////////////////////////////////////
		dateTextFieldCreation.setFont(new Font("Calibri", Font.BOLD, 20));
		dateTextFieldCreation.setBounds(255,240,200,25);
		
		dateTextFieldModified.setFont(new Font("Calibri", Font.BOLD, 20));
		dateTextFieldModified.setBounds(255,270,200,25);
		
		categoryList.setFont(new Font("Calibri", Font.BOLD, 20));
		categoryList.setBounds(255,210,200,25);
	
		RankList.setFont(new Font("Calibri", Font.BOLD, 20));
		RankList.setBounds(255,300,200,25);		
		
		comment1Input.setFont(new Font("Calibri", Font.BOLD, 20));
		comment1Input.setBounds(780,210,200,25);	
		
		characterCommentInput.setFont(new Font("Calibri", Font.BOLD, 20));
		characterCommentInput.setBounds(780,240,200,25);	
		
		dateTextFieldTRelease.setFont(new Font("Calibri", Font.BOLD, 20));
		dateTextFieldTRelease.setBounds(780,270,200,25);
		
		frmFavorites.getContentPane().add(categoryF);
		frmFavorites.getContentPane().add(titler);
		frmFavorites.getContentPane().add(creationD);
		frmFavorites.getContentPane().add(modificationD);
		frmFavorites.getContentPane().add(rankLoV);
		frmFavorites.getContentPane().add(comment1);
		frmFavorites.getContentPane().add(comment2);
		frmFavorites.getContentPane().add(dateOfRelease);
		frmFavorites.getContentPane().add(searchButton);
		frmFavorites.getContentPane().add(addButton);
		frmFavorites.getContentPane().add(editButton);
		frmFavorites.getContentPane().add(categoryList);
		frmFavorites.getContentPane().add(RankList);
		frmFavorites.getContentPane().add(dateTextFieldCreation);
		frmFavorites.getContentPane().add(dateTextFieldModified);
		frmFavorites.getContentPane().add(comment1Input);
		frmFavorites.getContentPane().add(characterCommentInput);
		frmFavorites.getContentPane().add(dateTextFieldTRelease);
		frmFavorites.getContentPane().add(addNewCateg);

		
		frmFavorites.setVisible(true);
	}
	
	
	

	public static void main(String[] args) {
		favoriteMain frameFav = new favoriteMain();

	}

}
