 
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
/*<html>
<applet code="Shooter5.class" height=2000 width=2000>
</applet>
</html>
*/
public class Shooter5 extends Applet{

	int movX,movY,k=0,score=0;
	TextField tf;
	Color c1=new Color(255,100,100);
	Image img;
	
	public void init()
	{
		int movX=-1,movY=-1;
		setBackground(Color.white);
		tf= new TextField(40);
		tf.setEditable(false);
		add(tf);
		tf.setBounds(300, 10, 400, 30);
    		setLayout(new BorderLayout());
    		Font myFont = new Font("TimesRoman", Font.BOLD, 24);
    		tf.setFont(myFont);
		img = getImage(getDocumentBase(), "myShooter.gif");
		tf.setText("  Welcome Shooter! Have fun! :-)  ");
	}
	
	public void paint(Graphics g) 
	{	
		g.drawString("SHOOTING",2000,2000);

		g.setColor(Color.blue);
		g.fillOval(1250,25,40,80);
		g.setColor(Color.red);
		g.fillOval(1260,45,20,40);
	
		g.setColor(Color.blue);
		g.fillOval(1250,200,40,80);
		g.setColor(Color.red);
		g.fillOval(1260,220,20,40);
		
		g.setColor(Color.blue);
		g.fillOval(1250,375,40,80);
		g.setColor(Color.red);
		g.fillOval(1260,395,20,40);

		g.setColor(Color.black);
		g.drawLine(250,0,250,2000);
			 
	 	if(movX>104)
	 	{
	 		tf.setText("Hey, No cheating! Move back!");
	 	}
		if(movX<=215 && movY<=600)
		{	
			g.drawImage(img,movX,movY,this);
			if(k==1)
			{
				g.setColor(c1);
				for(int i=500;i<550;i=i+20)
				{
					 for (int j=30;j<100000;j=j+20)
					 {
					 	repaint();
					 	g.fillOval(movX+j+110,movY+60,10,10);
					 }
					 k=0;
				}
				if(((movY+60)>0 && (movY+60)<95) || ((movY+60)>195 && (movY+60)<275) || ((movY+60)>370 && (movY+60)<450) )
				{
					if(((movY+60)>215 && (movY+60)<255) || ((movY+60)>40 && (movY+60)<80) || ((movY+60)>390 && (movY+60)<430) )
					{	
						score=score+100;
						tf.setText("  Bull's eye!!  Score: "+"  "+score);
					}	
					else
					{
						score=score+50;
						tf.setText("  It's a hit!  Score: "+"  "+score);
					}
				}	
				else
				{
					score=0;
				    	tf.setText("Oops! you missed it.  Score: "+score);
				}
			}
		}
	}
	
	
	public boolean mouseDown(Event evt,int x,int y)
	{
		movX=x;
		movY=y;	
	    	k=1;
		repaint();
		return true;
	}
}
