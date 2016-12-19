package test;

import org.bmsforum.jni.FlightData;

import image.tools.IViewer;
import img.ImageManipulation;

public class TestMain {
	
	public static void main(String[] args){
		FlightData flightData = new FlightData(true);		
					
		System.out.println(System.getProperty("java.library.path"));
		IViewer view = null;
		byte[][][] img = new byte[3][1200][1200];
		while(true){
//			System.out.println(flightData.getAUXTChan());
			int[] textures = flightData.getTextureData();
			int index = 0;
			for(int h = 0; h<1200; h++){
				for(int w = 0; w<1200; w++){
					img[0][h][w] = (byte) (textures[index]>>16);
					img[1][h][w] = (byte) (textures[index]>>8);
					img[2][h][w] = (byte) (textures[index]);
					index++;
				}
			}
			if(view==null){
				view = new IViewer(ImageManipulation.getBufferedImage(img));
				view.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
			}else{
				view.setImage(ImageManipulation.getBufferedImage(img));
			}
			
//			int l = 560;
//			for(int i = l*600; i<l*600+600; i++){
//				System.out.print(textures[i]+",");
//			}
//			System.out.println();
			
			
//			System.out.println(flightData.getfuelFlow());
//			int cTime = flightData.getcurrentTime();
//			int h = cTime /3600;
//			int m = (cTime - h*3600)/60;
//			int s = (cTime - h*3600 - m*60);
//			System.out.println(h+":"+m+":"+s);
			
//			System.out.println(flightData.getyaw()*180/Math.PI);
//			byte[][] ded = flightData.getDEDLines();
//			for(int i = 0; i<5; i++){
//				for(int x = 0; x<25; x++)
//					System.out.print((char)ded[i][x]);
//				System.out.print("\n");
//			}
//			
//			int rwrCount = flightData.getRwrObjectCount();
//			System.out.println(rwrCount);
//			int[] symbols = flightData.getRWRsymbol();
//			float[] bearing = flightData.getbearing();
//			long[] activity = flightData.getmissileActivity();
//			long[] selected = flightData.getselected();
//			for(int c = 0; c<rwrCount; c++){
//				System.out.println(symbols[c]+", "+bearing[c]+", "+activity[c]+", "+selected[c]);
//			}
			
			try {Thread.sleep(100);} catch (InterruptedException e) {e.printStackTrace();}
		}
	}

}
