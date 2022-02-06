package favorite;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.Action;
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

import com.mysql.cj.xdevapi.Statement;

public class favoriteMain implements ActionListener {
	final JButton searchButton = new JButton("Search");
	JTable table;
	DefaultTableModel model;
	String[] listCategory;
	int listTableRows;
	Object[][] listTable;
	
	JFormattedTextField dateTextFieldCreation;
	JFormattedTextField dateTextFieldModified;
	JFormattedTextField dateTextFieldTRelease;
	
	JTextField comment1Input;
	JTextField comment2Input;
	JComboBox RankList;
	JComboBox categoryList;

	favoriteMain() throws SQLException {

		String url = "jdbc:mysql://localhost:3306/favorite"; // 3306/"DataBase Name";
		String username = "root";
		String password = "ghjdfgh456";
		Connection connection = DriverManager.getConnection(url, username, password);
		///////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////
		String queryCountCategory = "SELECT max(id) as maxer FROM favorite.category;";

		java.sql.Statement statement = connection.createStatement(); // is an object that will allow user to send
																		// queries to java, a bridge.
		ResultSet rsMaxIdCategory = statement.executeQuery(queryCountCategory);
		rsMaxIdCategory.next();
		int numberCategories = rsMaxIdCategory.getInt("maxer"); // retrieve the line of My SQL
		System.out.println(numberCategories);

		/////////////////////////////////////////////////////
		int arrayExtraLimit = 100; // This value is the extra values that the array can take onve the program
									// starts. simply user can add 100 extra categories oce the system starts
		listCategory = new String[numberCategories + arrayExtraLimit];

		// In this are the array for "Category" LoV fills with value //Start
		for (int j = 1; j <= numberCategories; j++) {
			String queryCategoriesList = "SELECT categories FROM favorite.category Where id = '" + j + "'";
			ResultSet rsReturnCategories = statement.executeQuery(queryCategoriesList);
			// System.out.println("loop"+j);
			rsReturnCategories.next();
			listCategory[j - 1] = rsReturnCategories.getString("categories");
			// System.out.println("loop");
		}
		// In this are the array for "Category" LoV fills with value //End
		for (int t = 6; t < (numberCategories + arrayExtraLimit); t++) {
			listCategory[t] = "trash" + t;
		}
		///////////////////////////////////////////////////////////////
		// Load Table Values from SQL///Start
		String queryCountlistTableRows = "SELECT max(idRecords) as maxert FROM records;";
		ResultSet rsMaxIdTable = statement.executeQuery(queryCountlistTableRows);
		rsMaxIdTable.next();
		listTableRows = rsMaxIdTable.getInt("maxert");
		// System.out.print(listTableRows);
		listTable = new String[listTableRows + 20000][7];
		for (int l = 1; l <= listTableRows; l++) {
			for (int m = 1; m <= 7; m++) {
				String columnSQLTable = "";
				if (m == 1) {
					// columnSQLTable= "category";
					String queryTableItems = "SELECT category as maxek  FROM favorite.records WHERE idRecords = '" + l
							+ "'";
					ResultSet rsValueTable = statement.executeQuery(queryTableItems);
					rsValueTable.next();
					String tableItemStr = rsValueTable.getString("maxek");
					System.out.println(tableItemStr + "TestTester");
					listTable[l - 1][m - 1] = tableItemStr;

				} else if (m == 2) {
					// columnSQLTable= "comment1";
					String queryTableItems = "SELECT comment1 as maxek  FROM favorite.records WHERE idRecords = '" + l
							+ "'";
					ResultSet rsValueTable = statement.executeQuery(queryTableItems);
					rsValueTable.next();
					String tableItemStr = rsValueTable.getString("maxek");
					System.out.println(tableItemStr);
					listTable[l - 1][m - 1] = tableItemStr;
				} else if (m == 3) {
					// columnSQLTable= "comment2";
					String queryTableItems = "SELECT comment2 as maxek  FROM favorite.records WHERE idRecords = '" + l
							+ "'";
					ResultSet rsValueTable = statement.executeQuery(queryTableItems);
					rsValueTable.next();
					String tableItemStr = rsValueTable.getString("maxek");
					System.out.println(tableItemStr);
					listTable[l - 1][m - 1] = tableItemStr;
				} else if (m == 4) {
					// columnSQLTable= "ranker";
					String queryTableItems = "SELECT ranker as maxek  FROM favorite.records WHERE idRecords = '" + l
							+ "'";
					ResultSet rsValueTable = statement.executeQuery(queryTableItems);
					rsValueTable.next();
					String tableItemStr = rsValueTable.getString("maxek");
					System.out.println(tableItemStr);
					listTable[l - 1][m - 1] = tableItemStr;
				} else if (m == 5) {
					// columnSQLTable= "releaseDate";
					String queryTableItems = "SELECT releaseDate as maxek  FROM favorite.records WHERE idRecords = '"
							+ l + "'";
					ResultSet rsValueTable = statement.executeQuery(queryTableItems);
					rsValueTable.next();
					String tableItemStr = rsValueTable.getString("maxek");
					System.out.println(tableItemStr);
					listTable[l - 1][m - 1] = tableItemStr;
				} else if (m == 6) {
					// columnSQLTable= "modificationDate";
					String queryTableItems = "SELECT modificationDate as maxek  FROM favorite.records WHERE idRecords = '"
							+ l + "'";
					ResultSet rsValueTable = statement.executeQuery(queryTableItems);
					rsValueTable.next();
					String tableItemStr = rsValueTable.getString("maxek");
					System.out.println(tableItemStr);
					listTable[l - 1][m - 1] = tableItemStr;

				} else if (m == 7) {
					// columnSQLTable= "creationDate";
					String queryTableItems = "SELECT creationDate as maxek  FROM favorite.records WHERE idRecords = '"
							+ l + "'";
					ResultSet rsValueTable = statement.executeQuery(queryTableItems);
					rsValueTable.next();
					String tableItemStr = rsValueTable.getString("maxek");
					System.out.println(tableItemStr);
					listTable[l - 1][m - 1] = tableItemStr;
				}

			}

		}

		final JFrame frmFavorites = new JFrame();
		frmFavorites.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFavorites.setTitle("My Favorites");
		frmFavorites.getContentPane().setLayout(null);// It is important to remember that in order make a free GUI the
														// layout should be null
		frmFavorites.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmFavorites.setLocationRelativeTo(null);
		Border border = BorderFactory.createLineBorder(null, 5);

		// TitleLabel Start//
		final JLabel titler = new JLabel("My Favorite Project");
		titler.setVerticalAlignment(JLabel.TOP);
		titler.setHorizontalAlignment(JLabel.CENTER);
		titler.setBorder(null);
		titler.setBounds(435, 30, 400, 50);
		titler.setFont(new Font("Calibri", Font.BOLD, 40));
		// titler.setBorder(border);

		// TitleLabel END//

		// Category(LoV), Creation Date, Modification Date, Rank(1,10), Title,
		// DataSubjectANum, DataSubjectBText, DateOfRelease.

		final JLabel categoryF = new JLabel("Category:");
		// categoryF.setBorder(border);
		final JLabel creationD = new JLabel("Creation Date:");
		final JLabel modificationD = new JLabel("Modification Date:");
		final JLabel rankLoV = new JLabel("My Rank:");
		final JLabel comment1 = new JLabel("Rec Comment 1:");
		final JLabel comment2 = new JLabel("Rec Comment 2:");
		final JLabel dateOfRelease = new JLabel("Release Date:");// Calendar

		final JButton addButton = new JButton("Add Record");
		final JButton editButton = new JButton("Edit Record");
		final JButton addNewCateg = new JButton("New Category");

		categoryF.setFont(new Font("Calibri", Font.PLAIN, 20));
		categoryF.setBounds(80, 210, 200, 30);

		creationD.setFont(new Font("Calibri", Font.PLAIN, 20));
		creationD.setBounds(80, 240, 200, 30);

		modificationD.setFont(new Font("Calibri", Font.PLAIN, 20));
		modificationD.setBounds(80, 270, 200, 30);

		rankLoV.setFont(new Font("Calibri", Font.PLAIN, 20));
		rankLoV.setBounds(80, 300, 200, 30);

		comment1.setFont(new Font("Calibri", Font.PLAIN, 20));
		comment1.setBounds(580, 210, 200, 30);

		comment2.setFont(new Font("Calibri", Font.PLAIN, 20));
		comment2.setBounds(580, 240, 200, 30);

		dateOfRelease.setFont(new Font("Calibri", Font.PLAIN, 20));
		dateOfRelease.setBounds(580, 270, 200, 30);

		searchButton.setFont(new Font("Calibri", Font.BOLD, 20));
		searchButton.setBounds(1050, 210, 150, 25);
		searchButton.addActionListener((ActionListener) this);
		// Important(Always need an Action in order to use the Button)

		addButton.setFont(new Font("Calibri", Font.BOLD, 20));
		addButton.setBounds(1050, 240, 150, 25);

		editButton.setFont(new Font("Calibri", Font.BOLD, 20));
		editButton.setBounds(1050, 270, 150, 25);

		addNewCateg.setFont(new Font("Calibri", Font.BOLD, 20));
		addNewCateg.setBounds(1025, 340, 180, 28);
		/////////////////////////////////////
		categoryList = new JComboBox(listCategory);
		String list1_10[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		RankList = new JComboBox(list1_10);
		String valueHelp;
		for (int t = 6; t < (numberCategories + arrayExtraLimit); t++) {
			valueHelp = "trash" + t;
			categoryList.removeItem(valueHelp);
		}

		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		dateTextFieldCreation = new JFormattedTextField(dateformat);
		dateTextFieldModified = new JFormattedTextField(dateformat);
		dateTextFieldTRelease = new JFormattedTextField(dateformat);
		/*
		 * NumberFormatter numericFormat = new NumberFormatter();
		 * numericFormat.setValueClass(Long.class);
		 * numericFormat.setAllowsInvalid(true); JFormattedTextField comment1Input = new
		 * JFormattedTextField(numericFormat);
		 */
		comment1Input = new JTextField();
		comment2Input = new JTextField();

		/////////////////////////////////////
		String[] columnNames = { "Category", "Creation Date", "Modification Date", "My Rank", "Rec Comment 1",
				"Rec Comment 2", "Release Date" };
		model = new DefaultTableModel(listTable, columnNames);

		/////////////////////////////////////
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(80, 400, 1130, 320);
		frmFavorites.getContentPane().add(scrollPane);

		scrollPane.setViewportView(table);

		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Dialog", Font.BOLD, 18));

		/////////////////////////////////////
		dateTextFieldCreation.setFont(new Font("Calibri", Font.BOLD, 20));
		dateTextFieldCreation.setBounds(255, 240, 200, 25);

		dateTextFieldModified.setFont(new Font("Calibri", Font.BOLD, 20));
		dateTextFieldModified.setBounds(255, 270, 200, 25);

		categoryList.setFont(new Font("Calibri", Font.BOLD, 18));
		categoryList.setBounds(255, 210, 200, 25);

		RankList.setFont(new Font("Calibri", Font.BOLD, 20));
		RankList.setBounds(255, 300, 200, 25);

		comment1Input.setFont(new Font("Calibri", Font.BOLD, 20));
		comment1Input.setBounds(780, 210, 200, 25);

		comment2Input.setFont(new Font("Calibri", Font.BOLD, 20));
		comment2Input.setBounds(780, 240, 200, 25);

		dateTextFieldTRelease.setFont(new Font("Calibri", Font.BOLD, 20));
		dateTextFieldTRelease.setBounds(780, 270, 200, 25);

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
		frmFavorites.getContentPane().add(comment2Input);
		frmFavorites.getContentPane().add(dateTextFieldTRelease);
		frmFavorites.getContentPane().add(addNewCateg);

		frmFavorites.setVisible(true);
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void actionPerformed(java.awt.event.ActionEvent e) {
		
		String categorySearchValue = categoryList.getSelectedItem().toString();		
		String dateCreationValue = dateTextFieldCreation.getText();
		String dateModifiedValue = dateTextFieldModified.getText();
		String ranklValue = RankList.getSelectedItem().toString();	
		String comment1Value = comment1Input.getText();
		String comment2Value = comment2Input.getText();
		String dateReleaseValue = dateTextFieldTRelease.getText();
		
		if (e.getSource() == searchButton) {
		
			Object[][] searchArray = new String[listTableRows][7];
			for (int i=1; i<=listTableRows ; i++) {
				for (int m = 1; m <= 7; m++) {
					searchArray[i-1][m-1]= listTable[i-1][m-1];
				}				
			}
			
		}
		
	}

	public static void main(String[] args) throws SQLException {
		favoriteMain frameFav = new favoriteMain();
	}
}
