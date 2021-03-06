package databaseFrame.update;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import databaseMain.Update;
import databaseService.ItemService;
import databaseService.WeaponService;
import inventory.Item;
import inventory.Weapon;

public class WeaponUpdate {

	private JFrame frame;
	private JPanel contentPane;	
	private JTextField code;
	private JTextField name;
	private JTextField description;
	private JTextField inventorycode;
	private JTextField strength;
	
	private ItemService itemService;
	private WeaponService weaponService;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				run();
			}
		});
	}
	
	public void run() {
		try {
			WeaponUpdate window = new WeaponUpdate();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public WeaponUpdate() {
		initialize();
		weaponService = new WeaponService();
		itemService = new ItemService();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(getContentPane());
		frame.getContentPane().setLayout(null);
		Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize= frame.getSize();
		frame.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height+frameSize.height)/2);
		frame.setResizable(false);
	}
	
	private JPanel getContentPane() {
		if(contentPane == null) {
			contentPane = new JPanel();
			contentPane.setBackground(new Color(153, 204, 102));
			contentPane.setForeground(new Color(0, 0, 153));
			
			JLabel lblWeapon = new JLabel("Weapon");
			lblWeapon.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			lblWeapon.setForeground(new Color(51, 102, 153));
			lblWeapon.setBackground(Color.BLACK);
			lblWeapon.setBounds(26, 25, 106, 18);
			contentPane.add(lblWeapon);
			
			JLabel lblCode = new JLabel("Code:");
			lblCode.setForeground(new Color(0, 0, 153));
			lblCode.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblCode.setBounds(26, 61, 57, 18);
			contentPane.add(lblCode);
			
			code = new JTextField();
			code.setBounds(91, 56, 163, 24);
			contentPane.add(code);
			code.setColumns(10);
			
			JLabel lblName = new JLabel("name:");
			lblName.setForeground(new Color(0, 0, 153));
			lblName.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblName.setBounds(26, 92, 65, 18);
			contentPane.add(lblName);
			
			name = new JTextField();
			name.setBounds(91, 91, 86, 24);
			contentPane.add(name);
			name.setColumns(10);
			
			JLabel lblDescription = new JLabel("Description:");
			lblDescription.setForeground(new Color(0, 0, 153));
			lblDescription.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblDescription.setBounds(26, 128, 100, 18);
			contentPane.add(lblDescription);
			
			description = new JTextField();
			description.setBounds(179, 127, 163, 24);
			contentPane.add(description);
			description.setColumns(10);
			
			JLabel lblInventorycode = new JLabel("Inventorycode:");
			lblInventorycode.setForeground(new Color(0, 0, 153));
			lblInventorycode.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblInventorycode.setBounds(26, 159, 134, 18);
			contentPane.add(lblInventorycode);
			
			inventorycode = new JTextField();
			inventorycode.setBounds(179, 158, 163, 24);
			contentPane.add(inventorycode);
			inventorycode.setColumns(10);
			
			JLabel lblStrength = new JLabel("Strength:");
			lblStrength.setForeground(new Color(0, 0, 153));
			lblStrength.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
			lblStrength.setBounds(227, 92, 75, 18);
			contentPane.add(lblStrength);
			
			strength = new JTextField();
			strength.setBounds(316, 91, 86, 24);
			contentPane.add(strength);
			strength.setColumns(10);
			
			JButton btnUpdate = new JButton("UPDATE");
			btnUpdate.setFont(new Font("Arial Black", Font.PLAIN, 15));
			btnUpdate.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					int code2 = Integer.parseInt(code.getText());
					Item item = itemService.query(code2);
					item.setName(name.getText());
					item.setDescription(description.getText());
					item.setInventoryCode(Integer.parseInt(inventorycode.getText()));
					Weapon weapon = weaponService.query(code2);
					weapon.setStrength(Integer.parseInt(strength.getText()));
					itemService.update(item);
					weaponService.update(weapon);
					JOptionPane.showMessageDialog(null, "Update success", "message", JOptionPane.INFORMATION_MESSAGE);
				}
			});
			btnUpdate.setBounds(162, 213, 113, 27);
			contentPane.add(btnUpdate);
			
			JButton btnBack = new JButton("BACK");
			btnBack.setFont(new Font("Arial Black", Font.PLAIN, 15));
			btnBack.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Update update = new Update();
					update.run();
					frame.dispose();
				}
			});
			btnBack.setBounds(14, 213, 113, 27);
			contentPane.add(btnBack);
			
			JButton btnExit = new JButton("EXIT");
			btnExit.setFont(new Font("Arial Black", Font.PLAIN, 15));
			btnExit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					frame.dispose();
				}
			});
			btnExit.setBounds(305, 213, 113, 27);
			contentPane.add(btnExit);
		}
		return contentPane;
	}
}




