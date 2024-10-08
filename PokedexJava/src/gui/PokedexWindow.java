package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class PokedexWindow {

	private DummyMaker dummy;
	private JFrame frmPokedex;
	private JTextField textPokeEntry;
	private JTextField textRegion;
	private JTextField textDefense;
	private JTextField textSpeed;
	private JTextField textHp;
	private JTextField textWeight;
	private JTextField textHeight;
	private JLabel lblPokeType1;
	private JLabel lblPokeType2;
	private JLabel lblPokeEntry;
	private JLabel lblPokeImage;
	private JLabel lblWeak1;
	private JLabel lblWeak2;
	private JLabel lblWeak3;
	private JLabel lblWeak4;
	private JLabel lblWeak5;
	private JLabel lblWeak6;
	private JLabel lblStrong1;
	private JLabel lblStrong2;
	private JLabel lblStrong3;
	private JLabel lblStrong4;
	private JLabel lblStrong5;
	private JLabel lblStrong6;
	private JLabel lblPromAnalyzerHp;
	private JLabel lblPromAnalyzerDef;
	private JLabel lblPromAnalyzerSpeed;
	private JLabel lblPromAnalyzerWeight;
	private JLabel lblPromAnalyzerHeight;
	private JLabel lblStrong7;
	
	public PokedexWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPokedex = new JFrame();
		frmPokedex.setResizable(false);
		frmPokedex.setTitle("Pokedex");
		frmPokedex.setBounds(100, 100, 1432, 837);
		frmPokedex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmPokedex.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Pokédex");
		lblTitle.setFont(new Font("Trebuchet MS", Font.BOLD, 99));
		lblTitle.setVerticalAlignment(SwingConstants.TOP);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(507, 643, 619, 100);
		frmPokedex.getContentPane().add(lblTitle);
		
		JLabel lblPokeWeight = new JLabel("Weight:");
		lblPokeWeight.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPokeWeight.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblPokeWeight.setBounds(1157, 354, 102, 32);
		frmPokedex.getContentPane().add(lblPokeWeight);
		
		JLabel lblPokeHeight = new JLabel("Height:");
		lblPokeHeight.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPokeHeight.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblPokeHeight.setBounds(1167, 391, 92, 32);
		frmPokedex.getContentPane().add(lblPokeHeight);
		
		textPokeEntry = new JTextField();
		textPokeEntry.setBackground(new Color(128, 128, 128));
		textPokeEntry.setForeground(new Color(0, 0, 0));
		textPokeEntry.setHorizontalAlignment(SwingConstants.RIGHT);
		textPokeEntry.setOpaque(false);
		textPokeEntry.setFont(new Font("Trebuchet MS", Font.BOLD, 38));
		textPokeEntry.setBounds(658, 59, 316, 61);
		textPokeEntry.setBorder(null);
		frmPokedex.getContentPane().add(textPokeEntry);
		
		lblPokeEntry = new JLabel("Enter Pokemon Name");
		lblPokeEntry.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokeEntry.setFont(new Font("Trebuchet MS", Font.BOLD, 28));
		lblPokeEntry.setBounds(723, 150, 307, 32);
		frmPokedex.getContentPane().add(lblPokeEntry);
		
		JButton btnPokeEntry = new JButton("");
		btnPokeEntry.setBorder(null);
		btnPokeEntry.setIcon(new ImageIcon("pngs\\miscellaneous\\lupe.png"));
		btnPokeEntry.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		btnPokeEntry.setBackground(new Color(128, 128, 128));
		btnPokeEntry.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				entryPokeButtonClickled();		
			}

		});
		btnPokeEntry.setBounds(984, 59, 60, 61);
		frmPokedex.getContentPane().add(btnPokeEntry);
		
		textRegion = new JTextField();
		textRegion.setEditable(false);
		textRegion.setOpaque(false);
		textRegion.setBorder(null);
		textRegion.setForeground(new Color(0, 0, 0));
		textRegion.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		textRegion.setColumns(10);
		textRegion.setBounds(1269, 319, 95, 32);
		frmPokedex.getContentPane().add(textRegion);
		
		textDefense = new JTextField();
		textDefense.setEditable(false);
		textDefense.setOpaque(false);
		textDefense.setBorder(null);
		textDefense.setForeground(new Color(0, 0, 0));
		textDefense.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		textDefense.setColumns(10);
		textDefense.setBounds(1269, 249, 95, 32);
		frmPokedex.getContentPane().add(textDefense);
		
		textSpeed = new JTextField();
		textSpeed.setEditable(false);
		textSpeed.setOpaque(false);
		textSpeed.setBorder(null);
		textSpeed.setForeground(new Color(0, 0, 0));
		textSpeed.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		textSpeed.setColumns(10);
		textSpeed.setBounds(1269, 283, 95, 32);
		frmPokedex.getContentPane().add(textSpeed);
		
		textHp = new JTextField();
		textHp.setEditable(false);
		textHp.setOpaque(false);
		textHp.setBorder(null);
		textHp.setForeground(new Color(0, 0, 0));
		textHp.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		textHp.setColumns(10);
		textHp.setBounds(1269, 216, 95, 32);
		frmPokedex.getContentPane().add(textHp);
		
		textWeight = new JTextField();
		textWeight.setEditable(false);
		textWeight.setOpaque(false);
		textWeight.setBorder(null);
		textWeight.setForeground(new Color(0, 0, 0));
		textWeight.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		textWeight.setColumns(10);
		textWeight.setBounds(1269, 354, 95, 32);
		frmPokedex.getContentPane().add(textWeight);
		
		textHeight = new JTextField();
		textHeight.setEditable(false);
		textHeight.setOpaque(false);
		textHeight.setBorder(null);
		textHeight.setForeground(new Color(0, 0, 0));
		textHeight.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		textHeight.setColumns(10);
		textHeight.setBounds(1269, 389, 95, 32);
		frmPokedex.getContentPane().add(textHeight);
		
		JLabel lblPokeType = new JLabel("TYPES");
		lblPokeType.setBackground(new Color(0, 0, 0));
		lblPokeType.setForeground(new Color(0, 0, 0));
		lblPokeType.setFont(new Font("Trebuchet MS", Font.BOLD, 40));
		lblPokeType.setBounds(1136, 701, 173, 40);
		frmPokedex.getContentPane().add(lblPokeType);
		
		lblPokeImage = new JLabel("");
		lblPokeImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokeImage.setBounds(26, 92, 687, 512);
		frmPokedex.getContentPane().add(lblPokeImage);
		
		lblPokeType1 = new JLabel("");
		lblPokeType1.setIcon(new ImageIcon(""));
		lblPokeType1.setBounds(1136, 525, 216, 61);
		frmPokedex.getContentPane().add(lblPokeType1);
		
		lblPokeType2 = new JLabel("");
		lblPokeType2.setIcon(new ImageIcon(""));
		lblPokeType2.setBounds(1136, 596, 216, 61);
		frmPokedex.getContentPane().add(lblPokeType2);
		
		JLabel lblPokeWeak = new JLabel("WEAKNESS | STRENGTH:");
		lblPokeWeak.setHorizontalAlignment(SwingConstants.CENTER);
		lblPokeWeak.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblPokeWeak.setBounds(745, 263, 299, 40);
		frmPokedex.getContentPane().add(lblPokeWeak);
		
		JLabel lblRegion = new JLabel("Region:");
		lblRegion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRegion.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblRegion.setBounds(1124, 319, 135, 32);
		frmPokedex.getContentPane().add(lblRegion);
		
		JLabel lblSpeed = new JLabel("Speed:");
		lblSpeed.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSpeed.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblSpeed.setBounds(1167, 283, 92, 32);
		frmPokedex.getContentPane().add(lblSpeed);
		
		JLabel lblDefense = new JLabel("Defense:");
		lblDefense.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDefense.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblDefense.setBounds(1157, 249, 102, 32);
		frmPokedex.getContentPane().add(lblDefense);

		JLabel lblHp = new JLabel("HP:");
		lblHp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHp.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblHp.setBounds(1190, 216, 69, 32);
		frmPokedex.getContentPane().add(lblHp);
		
		JLabel lblStats = new JLabel("STATS");
		lblStats.setForeground(Color.BLACK);
		lblStats.setFont(new Font("Trebuchet MS", Font.BOLD, 65));
		lblStats.setBackground(Color.BLACK);
		lblStats.setBounds(1136, 92, 221, 61);
		frmPokedex.getContentPane().add(lblStats);
		
		lblWeak1 = new JLabel("");
		lblWeak1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWeak1.setIcon(new ImageIcon(""));
		lblWeak1.setBounds(723, 342, 158, 30);
		frmPokedex.getContentPane().add(lblWeak1);
		
		lblWeak2 = new JLabel("");
		lblWeak2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWeak2.setBounds(723, 378, 158, 30);
		frmPokedex.getContentPane().add(lblWeak2);
		
		lblWeak3 = new JLabel("");
		lblWeak3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWeak3.setBounds(723, 414, 158, 30);
		frmPokedex.getContentPane().add(lblWeak3);
		
		lblWeak4 = new JLabel("");
		lblWeak4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWeak4.setBounds(723, 454, 158, 30);
		frmPokedex.getContentPane().add(lblWeak4);
		
		lblWeak5 = new JLabel("");
		lblWeak5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWeak5.setBounds(724, 492, 158, 30);
		frmPokedex.getContentPane().add(lblWeak5);
		
		lblWeak6 = new JLabel("");
		lblWeak6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWeak6.setBounds(724, 529, 158, 30);
		frmPokedex.getContentPane().add(lblWeak6);

		lblStrong1 = new JLabel("");
		lblStrong1.setHorizontalAlignment(SwingConstants.LEFT);
		lblStrong1.setBounds(906, 342, 158, 30);
		frmPokedex.getContentPane().add(lblStrong1);
		
		lblStrong2 = new JLabel("");
		lblStrong2.setHorizontalAlignment(SwingConstants.LEFT);
		lblStrong2.setBounds(906, 372, 158, 30);
		frmPokedex.getContentPane().add(lblStrong2);
		
		lblStrong3 = new JLabel("");
		lblStrong3.setHorizontalAlignment(SwingConstants.LEFT);
		lblStrong3.setBounds(906, 402, 158, 30);
		frmPokedex.getContentPane().add(lblStrong3);
		
		lblStrong4 = new JLabel("");
		lblStrong4.setHorizontalAlignment(SwingConstants.LEFT);
		lblStrong4.setBounds(906, 432, 158, 30);
		frmPokedex.getContentPane().add(lblStrong4);
		
		lblStrong5 = new JLabel("");
		lblStrong5.setHorizontalAlignment(SwingConstants.LEFT);
		lblStrong5.setBounds(907, 462, 158, 30);
		frmPokedex.getContentPane().add(lblStrong5);
		
		lblStrong6 = new JLabel("");
		lblStrong6.setHorizontalAlignment(SwingConstants.LEFT);
		lblStrong6.setBounds(907, 492, 158, 30);
		frmPokedex.getContentPane().add(lblStrong6);
		
		lblStrong7 = new JLabel("");
		lblStrong7.setHorizontalAlignment(SwingConstants.LEFT);
		lblStrong7.setBounds(906, 522, 158, 30);
		frmPokedex.getContentPane().add(lblStrong7);

		lblPromAnalyzerHp = new JLabel("");
		lblPromAnalyzerHp.setBounds(1128, 216, 25, 25);
		frmPokedex.getContentPane().add(lblPromAnalyzerHp);	
		
		lblPromAnalyzerDef = new JLabel("");
		lblPromAnalyzerDef.setBounds(1128, 253, 25, 25);
		frmPokedex.getContentPane().add(lblPromAnalyzerDef);
		
		lblPromAnalyzerSpeed = new JLabel("");
		lblPromAnalyzerSpeed.setBounds(1128, 287, 25, 25);
		frmPokedex.getContentPane().add(lblPromAnalyzerSpeed);
		
		lblPromAnalyzerWeight = new JLabel("");
		lblPromAnalyzerWeight.setBounds(1128, 361, 25, 25);
		frmPokedex.getContentPane().add(lblPromAnalyzerWeight);
		
		lblPromAnalyzerHeight = new JLabel("");
		lblPromAnalyzerHeight.setBounds(1128, 398, 25, 25);
		frmPokedex.getContentPane().add(lblPromAnalyzerHeight);
		
		JLabel lblUpInd = new JLabel("Above Avg.");
		lblUpInd.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblUpInd.setHorizontalAlignment(SwingConstants.LEFT);
		lblUpInd.setBounds(1136, 176, 93, 25);
		lblUpInd.setIcon(new ImageIcon("pngs\\miscellaneous\\green-arrow.png"));
		frmPokedex.getContentPane().add(lblUpInd);
		
		
		JLabel lblBelowAvg = new JLabel("Below Avg.");
		lblBelowAvg.setHorizontalAlignment(SwingConstants.LEFT);
		lblBelowAvg.setIcon(new ImageIcon("pngs\\miscellaneous\\red-arrow.png"));
		lblBelowAvg.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblBelowAvg.setBounds(1245, 176, 113, 25);
		frmPokedex.getContentPane().add(lblBelowAvg);
		
		JLabel lblWallpaper = new JLabel("New label");
		lblWallpaper.setIcon(new ImageIcon("pngs\\miscellaneous\\wallpaperpokedex.png"));
		lblWallpaper.setBounds(0, 0, 1421, 800);
		frmPokedex.getContentPane().add(lblWallpaper);	
	}
		
	private void entryPokeButtonClickled() {
		boolean foundPokemon = false;
		dummy = null;
		
		for (DummyMaker pokemon : DataFinder.getPokemonList()) {
			if (pokemon.getName().toLowerCase().equals(textPokeEntry.getText().toLowerCase())) {
				dummy = pokemon; 
				textRegion.setText(dummy.getRegion());
				lblPokeEntry.setText(dummy.getRarity()+" Poke");
				
				if (dummy.getRarity().equals("Normal"))
					lblPokeEntry.setForeground(new Color(101, 72, 63));
				else if (dummy.getRarity().equals("Sub Legendary"))
					lblPokeEntry.setForeground(new Color(201, 63, 39));
				else if (dummy.getRarity().equals("Legendary"))
					lblPokeEntry.setForeground(new Color(201, 147, 39));
				else if (dummy.getRarity().equals("Mythical"))
					lblPokeEntry.setForeground(new Color(101, 39, 201));

				textDefense.setText(dummy.getDefense());
				textSpeed.setText(dummy.getSpeed());
				textHp.setText(dummy.getHp());
				textWeight.setText(dummy.getWeight()+" kg");
				textHeight.setText(dummy.getHeight()+" m");
				promAnalyzer();
				
				lblPokeType1.setIcon(new ImageIcon("pngs\\types\\"+dummy.getType1()+"pdx.png"));
				lblPokeType2.setIcon(new ImageIcon("pngs\\types\\"+dummy.getType2()+"pdx.png"));
				
				ImageIcon icon = new ImageIcon("pngs\\pokes\\"+dummy.getName().replaceAll(" ", "-").toLowerCase()+".png");
				Image img = icon.getImage();
				Image imgScale = img.getScaledInstance(icon.getIconWidth()*4, icon.getIconHeight()*4, Image.SCALE_SMOOTH);
				lblPokeImage.setIcon(new ImageIcon(imgScale));
				
				TypeCalc.typeCalculator(dummy.getType1());
				TypeCalc.typeCalculator(dummy.getType2());
				int[] typeValues = TypeCalc.getNewTypeValues();
				String[] typeNames = {"normalpdx", "firepdx", "waterpdx", "grasspdx", "electricpdx", "icepdx", "fightingpdx", "poisonpdx", 
		        	"groundpdx", "flyingpdx", "psychicpdx", "bugpdx", "rockpdx", "ghostpdx", "dragonpdx", "darkpdx", "steelpdx", "fairypdx"};
				int n = 1;
				boolean placeSomething = true;
				resetImages();
				
				for (int i = 0; i < 18; i++) {
					placeSomething = true;
					
					if (n == 1 && typeValues[i] < 0) { 
						icon = new ImageIcon("pngs\\types\\"+typeNames[i]+".png");
						imgScale = icon.getImage().getScaledInstance(icon.getIconWidth()/2, icon.getIconHeight()/2, Image.SCALE_SMOOTH);
						lblWeak1.setIcon(new ImageIcon(imgScale)); placeSomething = false; }
					if (n == 2 && typeValues[i] < 0) { 
						icon = new ImageIcon("pngs\\types\\"+typeNames[i]+".png");
						imgScale = icon.getImage().getScaledInstance(icon.getIconWidth()/2, icon.getIconHeight()/2, Image.SCALE_SMOOTH);
						lblWeak2.setIcon(new ImageIcon(imgScale)); placeSomething = false; }
					if (n == 3 && typeValues[i] < 0) { 
						icon = new ImageIcon("pngs\\types\\"+typeNames[i]+".png");
						imgScale = icon.getImage().getScaledInstance(icon.getIconWidth()/2, icon.getIconHeight()/2, Image.SCALE_SMOOTH);
						lblWeak3.setIcon(new ImageIcon(imgScale)); placeSomething = false; }
					if (n == 4 && typeValues[i] < 0) { 
						icon = new ImageIcon("pngs\\types\\"+typeNames[i]+".png");
						imgScale = icon.getImage().getScaledInstance(icon.getIconWidth()/2, icon.getIconHeight()/2, Image.SCALE_SMOOTH);
						lblWeak4.setIcon(new ImageIcon(imgScale)); placeSomething = false; }
					if (n == 5 && typeValues[i] < 0) { 
						icon = new ImageIcon("pngs\\types\\"+typeNames[i]+".png");
						imgScale = icon.getImage().getScaledInstance(icon.getIconWidth()/2, icon.getIconHeight()/2, Image.SCALE_SMOOTH);
						lblWeak5.setIcon(new ImageIcon(imgScale)); placeSomething = false; }
					if (n == 6 && typeValues[i] < 0) {
						icon = new ImageIcon("pngs\\types\\"+typeNames[i]+".png");
						imgScale = icon.getImage().getScaledInstance(icon.getIconWidth()/2, icon.getIconHeight()/2, Image.SCALE_SMOOTH);
						lblWeak6.setIcon(new ImageIcon(imgScale)); placeSomething = false; }						
					
					if (!placeSomething)
						n++;
				}
				
				n=1; 
				for (int i = 0; i < 17; i++) {
					placeSomething = true;
					
					if (n == 1 && typeValues[i] >= 1) { 
						icon = new ImageIcon("pngs\\types\\"+typeNames[i]+".png");
						imgScale = icon.getImage().getScaledInstance(icon.getIconWidth()/2, icon.getIconHeight()/2, Image.SCALE_SMOOTH);
						lblStrong1.setIcon(new ImageIcon(imgScale)); placeSomething = false; }
					if (n == 2 && typeValues[i] >= 1) { 
						icon = new ImageIcon("pngs\\types\\"+typeNames[i]+".png");
						imgScale = icon.getImage().getScaledInstance(icon.getIconWidth()/2, icon.getIconHeight()/2, Image.SCALE_SMOOTH);
						lblStrong2.setIcon(new ImageIcon(imgScale)); placeSomething = false; }
					if (n == 3 && typeValues[i] >= 1) { 
						icon = new ImageIcon("pngs\\types\\"+typeNames[i]+".png");
						imgScale = icon.getImage().getScaledInstance(icon.getIconWidth()/2, icon.getIconHeight()/2, Image.SCALE_SMOOTH);
						lblStrong3.setIcon(new ImageIcon(imgScale)); placeSomething = false; }
					if (n == 4 && typeValues[i] >= 1) { 
						icon = new ImageIcon("pngs\\types\\"+typeNames[i]+".png");
						imgScale = icon.getImage().getScaledInstance(icon.getIconWidth()/2, icon.getIconHeight()/2, Image.SCALE_SMOOTH);
						lblStrong4.setIcon(new ImageIcon(imgScale)); placeSomething = false; }
					if (n == 5 && typeValues[i] >= 1) { 
						icon = new ImageIcon("pngs\\types\\"+typeNames[i]+".png");
						imgScale = icon.getImage().getScaledInstance(icon.getIconWidth()/2, icon.getIconHeight()/2, Image.SCALE_SMOOTH);
						lblStrong5.setIcon(new ImageIcon(imgScale)); placeSomething = false; }
					if (n == 6 && typeValues[i] >= 1) {
						icon = new ImageIcon("pngs\\types\\"+typeNames[i]+".png");
						imgScale = icon.getImage().getScaledInstance(icon.getIconWidth()/2, icon.getIconHeight()/2, Image.SCALE_SMOOTH);
						lblStrong6.setIcon(new ImageIcon(imgScale)); placeSomething = false; }		
					if (n == 7 && typeValues[i] >= 1) {
						icon = new ImageIcon("pngs\\types\\"+typeNames[i]+".png");
						imgScale = icon.getImage().getScaledInstance(icon.getIconWidth()/2, icon.getIconHeight()/2, Image.SCALE_SMOOTH);
						lblStrong7.setIcon(new ImageIcon(imgScale)); placeSomething = false; }
					
					if (!placeSomething)
						n++;
				}
				
				TypeCalc.resetTypeValues();
				foundPokemon = true;
				break;
			}

		}  if (!foundPokemon) {
			lblPokeEntry.setText("Invalid Pokemon!");
			lblPokeEntry.setVisible(true);
		}
	}

	public void setVisibility(boolean b) {
		// TODO Auto-generated method stub
		frmPokedex.setVisible(b);
	}
	
	private void resetImages() {
		lblWeak1.setIcon(null); lblWeak2.setIcon(null); lblWeak3.setIcon(null); lblWeak4.setIcon(null); lblWeak5.setIcon(null); lblWeak6.setIcon(null);
		lblStrong1.setIcon(null); lblStrong2.setIcon(null); lblStrong3.setIcon(null); lblStrong4.setIcon(null); lblStrong5.setIcon(null); lblStrong6.setIcon(null); lblStrong7.setIcon(null);
	}
	
	private void promAnalyzer() {
		if (DataFinder.getHpAverage() < Integer.parseInt(dummy.getHp()))
		lblPromAnalyzerHp.setIcon(new ImageIcon("pngs\\miscellaneous\\green-arrow.png"));
		else lblPromAnalyzerHp.setIcon(new ImageIcon("pngs\\miscellaneous\\red-arrow.png"));
		
		if (DataFinder.getDefenseAverage() < Integer.parseInt(dummy.getDefense()))
		lblPromAnalyzerDef.setIcon(new ImageIcon("pngs\\miscellaneous\\green-arrow.png"));
		else lblPromAnalyzerDef.setIcon(new ImageIcon("pngs\\miscellaneous\\red-arrow.png"));
		
		if (DataFinder.getSpeedAverage() < Integer.parseInt(dummy.getSpeed()))
		lblPromAnalyzerSpeed.setIcon(new ImageIcon("pngs\\miscellaneous\\green-arrow.png"));
		else lblPromAnalyzerSpeed.setIcon(new ImageIcon("pngs\\miscellaneous\\red-arrow.png"));
		
		if (DataFinder.getWeightAverage() < Double.parseDouble(dummy.getWeight()))
		lblPromAnalyzerWeight.setIcon(new ImageIcon("pngs\\miscellaneous\\heavy.png"));
		else lblPromAnalyzerWeight.setIcon(new ImageIcon("pngs\\miscellaneous\\feather.png"));
		
		if (DataFinder.getHeightAverage() < Double.parseDouble(dummy.getHeight()))
		lblPromAnalyzerHeight.setIcon(new ImageIcon("pngs\\miscellaneous\\tall.png"));
		else lblPromAnalyzerHeight.setIcon(new ImageIcon("pngs\\miscellaneous\\short.png"));
	}
}
