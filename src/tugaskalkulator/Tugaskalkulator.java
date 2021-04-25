package tugaskalkulator;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class kalkulator extends JFrame implements ActionListener {
	String satu, dua, tiga;
        static JFrame f;
	static JTextField l;
	kalkulator()
	{
		satu = dua = tiga = "";
	}

	public static void main(String args[])
	{
		f = new JFrame("kalkulator");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		kalkulator k = new kalkulator();
		l = new JTextField(16);
		l.setEditable(false);
		JButton tombol0, tombol1, tombol2, tombol3, tombol4, tombol5, tombol6, tombol7, tombol8, tombol9, tombolTambah, tombolKurang, tombolBagi, 
                        tombolKali, tombolE, tombolClear, tombolHasil;
		tombol0 = new JButton("0");
		tombol1 = new JButton("1");
		tombol2 = new JButton("2");
		tombol3 = new JButton("3");
		tombol4 = new JButton("4");
		tombol5 = new JButton("5");
		tombol6 = new JButton("6");
		tombol7 = new JButton("7");
		tombol8 = new JButton("8");
		tombol9 = new JButton("9");
		tombolHasil = new JButton("=");
		tombolTambah = new JButton("+");
		tombolKurang = new JButton("-");
		tombolBagi = new JButton("/");
		tombolKali = new JButton("*");
		tombolClear = new JButton("C");
		tombolE = new JButton(".");
		JPanel p = new JPanel();

		tombolKali.addActionListener(k);
		tombolBagi.addActionListener(k);
		tombolKurang.addActionListener(k);
		tombolTambah.addActionListener(k);
		tombol9.addActionListener(k);
		tombol8.addActionListener(k);
		tombol7.addActionListener(k);
		tombol6.addActionListener(k);
		tombol5.addActionListener(k);
		tombol4.addActionListener(k);
		tombol3.addActionListener(k);
		tombol2.addActionListener(k);
		tombol1.addActionListener(k);
		tombol0.addActionListener(k);
		tombolE.addActionListener(k);
		tombolClear.addActionListener(k);
		tombolHasil.addActionListener(k);
                p.setBackground(Color.green);

		p.add(l);
		p.add(tombol1);
		p.add(tombol2);
		p.add(tombol3);
		p.add(tombol4);
		p.add(tombol5);
		p.add(tombol6);
		p.add(tombol7);
		p.add(tombol8);
		p.add(tombol9);
                p.add(tombol0);
		p.add(tombolBagi);
                p.add(tombolKurang);
                p.add(tombolKali);
                p.add(tombolTambah);
		p.add(tombolE);
		p.add(tombolClear);
		p.add(tombolHasil);
		f.add(p);
		f.setSize(180, 240);
		f.show();
	}
	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();
		if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
			if (!dua.equals(""))
				tiga = tiga + s;
			else
				satu = satu + s;

			l.setText(satu + dua + tiga);
		}
		else if (s.charAt(0) == 'C') {
			satu = dua = tiga = "";
			l.setText(satu + dua + tiga);
		}
		else if (s.charAt(0) == '=') {

			double te;
			if (dua.equals("+"))
				te = (Double.parseDouble(satu) + Double.parseDouble(tiga));
			else if (dua.equals("-"))
				te = (Double.parseDouble(satu) - Double.parseDouble(tiga));
			else if (dua.equals("/"))
				te = (Double.parseDouble(satu) / Double.parseDouble(tiga));
			else
				te = (Double.parseDouble(satu) * Double.parseDouble(tiga));
			l.setText(satu + dua + tiga + "=" + te);
			satu = Double.toString(te);
			dua = tiga = "";
		}
		else {
			if (dua.equals("") || tiga.equals(""))
				dua = s;
			else {
				double te;

				if (dua.equals("+"))
					te = (Double.parseDouble(satu) + Double.parseDouble(tiga));
				else if (dua.equals("-"))
					te = (Double.parseDouble(satu) - Double.parseDouble(tiga));
				else if (dua.equals("/"))
					te = (Double.parseDouble(satu) / Double.parseDouble(tiga));
				else
					te = (Double.parseDouble(satu) * Double.parseDouble(tiga));
				satu = Double.toString(te);
				dua = s;
				tiga = "";
			}
			l.setText(satu + dua + tiga);
		}
	}
}
