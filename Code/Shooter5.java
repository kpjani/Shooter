 
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
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
		tf.setBounds(300, 10, 310, 20);
    	setLayout(new BorderLayout());
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
			 
	 	if(movX>100)
	 	{
	 		tf.setText("  Hey, No cheating! please move back and try again!");
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
				if(((movY+60)>0 && (movY+60)<100) || ((movY+60)>200 && (movY+60)<280) || ((movY+60)>375 && (movY+60)<455) )
				{
					if(((movY+60)>220 && (movY+60)<260) || ((movY+60)>45 && (movY+60)<85) || ((movY+60)>395 && (movY+60)<435) )
					{	
						score=score+100;
						tf.setText("  Bull's eye!! That was awesome.	Score: "+"  "+score);
					}	
					else
					{
						score=score+50;
						tf.setText("  It's a hit! very nice.	Score: "+"  "+score);
					}
				}	
				else
				{
					score=0;
				    tf.setText("Oops! you missed the target. Try again.  Score: "+score);
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