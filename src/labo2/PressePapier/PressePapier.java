package labo2.PressePapier;

import java.awt.Point;

import labo2.Model.Perspective;
import labo2.Strategie.*;

public class PressePapier {
	
	
	public static StrategieCopierColler strategie = new StrategiePositionZoom();
	
	Point position = new Point(0, 0);
	Point size = new Point(0, 0);
	
	
	public static boolean CopyPos = true;
	public static boolean CopyZoom = true;
	
	public static PressePapier pressePapier = null;

	
	public static void GetPress(Perspective perspective) {
		
	}
	public Point GetPressePosition() {
		return position;
	}
	public Point GetPresseSize() {
		return size;
	}


	public void SetPosition(Point point) {
		// TODO Auto-generated method stub
		position = point;
	}
	public void SetSize(Point point) {
		// TODO Auto-generated method stub
		size = point;
	}
	public static void ClearPressePapier() {
		pressePapier = null;
	}
	public static void Copier(Perspective perspective) {
		// TODO Auto-generated method stub
		pressePapier = strategie.Copier(perspective);
	}
	
	public static void Coller(Perspective perspective) {
		// TODO Auto-generated method stub
		strategie.Coller(perspective);
	}

	public static void SetStrategie(boolean strategiePosition, boolean strategieSize) {
		// TODO Auto-generated method stub
		if(false == strategiePosition && false == strategieSize) {
			
		}else {
			CopyPos = strategiePosition;
			CopyZoom = strategieSize;
			
			if(CopyPos && CopyZoom) {
				strategie = new StrategiePositionZoom();
				System.out.println("Strategie Position Zoom");
			}else if(!CopyPos && CopyZoom) {
				strategie = new StrategieZoom();
				System.out.println("Strategie Zoom");
				
			}else if(CopyPos && !CopyZoom) {
				strategie = new StrategiePosition();
				System.out.println("Strategie Position");
				
			}
			
		}
	}
	

}
