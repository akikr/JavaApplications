import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class TikTacToe
{
	JFrame frame;
	JTextField tf1,tf2;
	JPanel p1,p2,p3;
	JButton[] b;
	int res=0;
	TikTacToe()
	{
		try{UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
		catch(Exception e){System.out.println("Error Setting Native LookAndFeel:"+e);}
		frame=new JFrame("TikTacToe");
		Toolkit t=frame.getToolkit();
		Dimension screenSize=t.getScreenSize();
		int width=screenSize.width*3/10;
		int height=screenSize.height*5/10;
		frame.setBounds(width/7,height/7,width,height);
		tf1=new JTextField("RESULT");					//"1st Player WON !!" "2nd Player WON !!" "It's a DRAW !!!" 
		tf1.setFont(new Font("Tahoma",Font.PLAIN,20));
		tf1.setEditable(false);
		tf1.setBackground(Color.WHITE);
		p1=new JPanel();
		p1.add(tf1);
		p1.setLayout(new GridLayout(1,1,0,0));
		frame.add(p1,BorderLayout.NORTH);
		p2=new JPanel();
		b=new JButton[9];
		for(int i=0;i<b.length;i++)
		{
			b[i]=new JButton("");
			b[i].setBackground(Color.BLACK);
			b[i].setFont(new Font("Tahoma",Font.PLAIN,50));
			b[i].addActionListener(new ButtonEventListener(this));
			p2.add(b[i]);
		}
		p2.setLayout(new GridLayout(3,3,0,0));
		frame.add(p2,BorderLayout.CENTER);
		tf2=new JTextField("	    PLAY: 1st Player");	//"	    PLAY: 2nd Player" "	    GAME OVER"
		tf2.setFont(new Font("Tahoma",Font.PLAIN,15));
		tf2.setEditable(false);
		tf2.setBackground(Color.WHITE);
		p3=new JPanel();
		p3.add(tf2);
		p3.setLayout(new GridLayout(1,1,0,0));
		frame.add(p3,BorderLayout.SOUTH);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	public static void main(String... args){
		new TikTacToe();
	}
}
class ButtonEventListener implements ActionListener
{
	TikTacToe be;
	int ck=0;
	ButtonEventListener(TikTacToe be)
	{
		this.be=be;
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("")&&be.res==0)
		{
			int ct=0;
			for(int i=0;i<be.b.length;i++)
			{
				String sck=be.b[i].getText();
				if(sck=="")
					{ct++;}
			}
			if(ct%2!=0)
			{
				for(int i=0;i<be.b.length;i++)
				{
					if(e.getSource()==be.b[i])
					{
						be.b[i].setText("0");be.tf2.setText("	    PLAY: 2nd Player");
						be.res=resultCheck();
						break;
					}
				}
			}
			else
			{
				for(int i=0;i<be.b.length;i++)
				{
					if(e.getSource()==be.b[i])
					{
						be.b[i].setText("X");be.tf2.setText("	    PLAY: 1st Player");
						be.res=resultCheck();
						break;
					}
				}
			}
			if(ct==1&&be.res==0)
			{
				be.tf1.setText("RESULT:It's a DRAW !!!");be.tf1.setBackground(Color.yellow);
				be.tf2.setText("	    GAME OVER");;be.tf2.setBackground(Color.red);
			}
		}
	}
	public int resultCheck()
	{
		if(be.b[0].getText()==be.b[1].getText()&&be.b[0].getText()!="")
		{
			if(be.b[1].getText()==be.b[2].getText())
			{
				if(be.b[2].getText()=="0")
					{be.tf1.setText("RESULT:1st Player WON !!");be.tf1.setBackground(Color.green);}
				else
					{be.tf1.setText("RESULT:2nd Player WON !!");be.tf1.setBackground(Color.green);}
				be.tf2.setText("	    GAME OVER");be.tf2.setBackground(Color.red);
				ck=1;
			}
		}
		if(be.b[3].getText()==be.b[4].getText()&&be.b[3].getText()!="")
		{
			if(be.b[4].getText()==be.b[5].getText())
			{
				if(be.b[5].getText()=="0")
					{be.tf1.setText("RESULT:1st Player WON !!");be.tf1.setBackground(Color.green);}
				else
					{be.tf1.setText("RESULT:2nd Player WON !!");be.tf1.setBackground(Color.green);}
				be.tf2.setText("	    GAME OVER");be.tf2.setBackground(Color.red);
				ck=1;
			}
		}
		if(be.b[6].getText()==be.b[7].getText()&&be.b[6].getText()!="")
		{
			if(be.b[7].getText()==be.b[8].getText())
			{
				if(be.b[8].getText()=="0")
					{be.tf1.setText("RESULT:1st Player WON !!");be.tf1.setBackground(Color.green);}
				else
					{be.tf1.setText("RESULT:2nd Player WON !!");be.tf1.setBackground(Color.green);}
				be.tf2.setText("	    GAME OVER");be.tf2.setBackground(Color.red);
				ck=1;
			}
		}
		if(be.b[0].getText()==be.b[3].getText()&&be.b[0].getText()!="")
		{
			if(be.b[3].getText()==be.b[6].getText())
			{
				if(be.b[6].getText()=="0")
					{be.tf1.setText("RESULT:1st Player WON !!");be.tf1.setBackground(Color.green);}
				else
					{be.tf1.setText("RESULT:2nd Player WON !!");be.tf1.setBackground(Color.green);}
				be.tf2.setText("	    GAME OVER");be.tf2.setBackground(Color.red);
				ck=1;
			}
		}
		if(be.b[1].getText()==be.b[4].getText()&&be.b[1].getText()!="")
		{
			if(be.b[4].getText()==be.b[7].getText())
			{
				if(be.b[7].getText()=="0")
					{be.tf1.setText("RESULT:1st Player WON !!");be.tf1.setBackground(Color.green);}
				else
					{be.tf1.setText("RESULT:2nd Player WON !!");be.tf1.setBackground(Color.green);}
				be.tf2.setText("	    GAME OVER");be.tf2.setBackground(Color.red);
				ck=1;
			}
		}
		if(be.b[2].getText()==be.b[5].getText()&&be.b[2].getText()!="")
		{
			if(be.b[5].getText()==be.b[8].getText())
			{
				if(be.b[8].getText()=="0")
					{be.tf1.setText("RESULT:1st Player WON !!");be.tf1.setBackground(Color.green);}
				else
					{be.tf1.setText("RESULT:2nd Player WON !!");be.tf1.setBackground(Color.green);}
				be.tf2.setText("	    GAME OVER");be.tf2.setBackground(Color.red);
				ck=1;
			}
		}
		if(be.b[0].getText()==be.b[4].getText()&&be.b[0].getText()!="")
		{
			if(be.b[4].getText()==be.b[8].getText())
			{
				if(be.b[8].getText()=="0")
					{be.tf1.setText("RESULT:1st Player WON !!");be.tf1.setBackground(Color.green);}
				else
					{be.tf1.setText("RESULT:2nd Player WON !!");be.tf1.setBackground(Color.green);}
				be.tf2.setText("	    GAME OVER");be.tf2.setBackground(Color.red);
				ck=1;
			}
		}
		if(be.b[6].getText()==be.b[4].getText()&&be.b[6].getText()!="")
		{
			if(be.b[4].getText()==be.b[2].getText())
			{
				if(be.b[2].getText()=="0")
					{be.tf1.setText("RESULT:1st Player WON !!");be.tf1.setBackground(Color.green);}
				else
					{be.tf1.setText("RESULT:2nd Player WON !!");be.tf1.setBackground(Color.green);}
				be.tf2.setText("	    GAME OVER");be.tf2.setBackground(Color.red);
				ck=1;
			}
		}
		return ck;
	}
}