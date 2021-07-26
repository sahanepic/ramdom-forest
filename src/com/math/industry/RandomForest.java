package com.math.industry;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RandomForest {
public static void main(String args[]) {
	String[][] input = 
	
//
//			{{"Yes","No","No","Yes","No","Yes","No","Positive"}, 
//				{"No","No","No","Yes","Yes","Yes","No","Positive"},
//				{"Yes","Yes","No","No","No","Yes","No","Negative"},
//				{"Yes","Yes","Yes","Yes","No","Yes","Yes","Positive"},
//				{"Yes","No","No","Yes","No","Yes","No","Positive"},
//				{"Yes","No","Yes","Yes","Yes","Yes","No","Positive"},
//				{"No","No","No","Yes","Yes","Yes","No","Positive"},
//				{"Yes","Yes","No","No","Yes","Yes","Yes","Positive"},
//				{"Yes","Yes","No","Yes","No","Yes","No","Positive"},
//				{"Yes","Yes","No","Yes","Yes","Yes","No","Positive"}};
			
			Read_Excel_Data();
	
	
	for(int i = 0; i<78; i++)
	{
	    for(int j = 0; j<8; j++)
	    {
	        System.out.print(input[i][j] +"\t" );
	    }
	    System.out.println();
	}
		
//		{{"Yes","No","No","Yes","No","Yes","No","Positive"}, 
//			{"No","No","No","Yes","Yes","Yes","No","Positive"},
//			{"Yes","Yes","No","No","No","Yes","No","Negative"},
//			{"Yes","Yes","Yes","Yes","No","Yes","Yes","Positive"},
//			{"Yes","No","No","Yes","No","Yes","No","Positive"},
//			{"Yes","No","Yes","Yes","Yes","Yes","No","Positive"},
//			{"No","No","No","Yes","Yes","Yes","No","Positive"},
//			{"Yes","Yes","No","No","Yes","Yes","Yes","Positive"},
//			{"Yes","Yes","No","Yes","No","Yes","No","Positive"},
//			{"Yes","Yes","No","Yes","Yes","Yes","No","Positive"}};
	
	 
	
	for(int i=0;i<input.length;i++) {
		if(tree1(i,input)) {
			System.out.println("Tree 1 : Postive");
			
		}
		else {
			System.out.println("Tree 1 : Negative");
		}
		
		
		if(tree2(i,input)) {
			System.out.println("Tree 2 : Postive");
			
		}
		else 
			System.out.println("Tree 2 : Negative");
		
		if(tree3(i,input)) {
			System.out.println("Tree 3 : Postive");
			
		}
		else 
			System.out.println("Tree 3 : Negative");
		
		if(tree4(i,input)) {
			System.out.println("Tree 4 : Postive");
			
		}
		else 
			System.out.println("Tree 4 : Negative");
		
		if(tree5(i,input)) {
			System.out.println("Tree 5 : Postive");
			
		}
		else 
			System.out.println("Tree 5 : Negative");
		
		if(tree6(i,input)) {
			System.out.println("Tree 6 : Postive");
			
		}
		else 
			System.out.println("Tree 6 : Negative");
		
		if(tree7(i,input)) {
			System.out.println("Tree 7 : Postive");
			
		}
		else 
			System.out.println("Tree 7 : Negative");
		
		if(tree8(i,input)) {
			System.out.println("Tree 8 : Postive");
			
		}
		else 
			System.out.println("Tree 8 : Negative");
		
		if(tree9(i,input)) {
			System.out.println("Tree 9 : Postive");
			
		}
		else 
			System.out.println("Tree 9 : Negative");
		
		if(tree10(i,input)) {
			System.out.println("Tree 10 : Postive");
			
		}
		else 
			System.out.println("Tree 10 : Negative");
		
		
		Boolean [] majority = {(tree1(i,input)),(tree2(i,input)),(tree3(i,input)),(tree4(i,input)),(tree5(i,input)),
				(tree6(i,input)),(tree7(i,input)),(tree8(i,input)),(tree9(i,input)),(tree10(i,input))};
		
		int n = majority.length;
		
		findMajority(majority, n);
		
		
		boolean result =  randomeThreeMax(majority);
		System.out.println( "The Result  "  + result);
		
		//System.out.println(trees(i,input));
		
		
		System.out.print("\n");
	}
	
}


public static boolean tree1(int i,String[][] input ) {
	// Tree 1
	//0				1				2				3				4				5				6			7
	//Pregnancies	Glucose			BloodPressure	SkinThickness	Insulin			BMI				Age			Outcome
	//(> 0 , Yes)	(>110 , Yes)	(>80 , Yes)		(>30 , Yes)		(>150 , Yes)	(>18.5 , Yes)	(>50 , Yes)
	//65%

	if(input[i][1]=="No") {
		if(input[i][2]=="No") {
			if(input[i][4]=="No") {
				return false;
			}
			else {
				return false;
			}
		}
		else {
			if(input[i][0]=="Yes") {
				return true;
			}
			else {
				return false;
			}
		}
	}
	else {
		if(input[i][4]=="No") {
			if(input[i][2]=="No") {
				if(input[i][0]=="Yes") {
					return false;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		else {
			if(input[i][0]=="Yes") {
				if(input[i][2]=="No") {
					return false;
				}
				else {
					return false;
				}
			}
			else {
				return true;
			}
		}
	}
}

public static boolean tree2(int i,String[][] input ) {
	// Tree 2
	//0				1				2				3				4				5				6			7
	//Pregnancies	Glucose			BloodPressure	SkinThickness	Insulin			BMI				Age			Outcome
	//(> 0 , Yes)	(>110 , Yes)	(>80 , Yes)		(>30 , Yes)		(>150 , Yes)	(>18.5 , Yes)	(>50 , Yes)
	//68%
	
	if(input[i][6]=="Yes") {
		return true;
	}
	else {
		if(input[i][2]=="No") {
			if(input[i][1]=="No") {
				if(input[i][4]=="No") {
					return false;
				}
				else {
					return false;
				}
			}
			else {
				if(input[i][4]=="No") {
					return false;
				}
				else {
					return false;
				}
			}
		}
		else {
			return false;
		}
	}
}

public static boolean tree3(int i,String[][] input ) {
	// Tree 3
	//0				1				2				3				4				5				6			7
	//Pregnancies	Glucose			BloodPressure	SkinThickness	Insulin			BMI				Age			Outcome
	//(> 0 , Yes)	(>110 , Yes)	(>80 , Yes)		(>30 , Yes)		(>150 , Yes)	(>18.5 , Yes)	(>50 , Yes)
	//62%
	
	if(input[i][2]=="No") {
		if(input[i][0]=="No") {
			return false;
		}
		else {
			if(input[i][3]=="Yes") {
				return true;
			}
			else {
				return false;
			}
		}
	}
	else {
		if(input[i][0]=="No") {
			return true;
		}
		else {
			return false;
		}
	}
}

public static boolean tree4(int i,String[][] input ) {
	// Tree 4
	//0				1				2				3				4				5				6			7
	//Pregnancies	Glucose			BloodPressure	SkinThickness	Insulin			BMI				Age			Outcome
	//(> 0 , Yes)	(>110 , Yes)	(>80 , Yes)		(>30 , Yes)		(>150 , Yes)	(>18.5 , Yes)	(>50 , Yes)
	//78%
	
	if(input[i][3]=="No") {
		if(input[i][0]=="Yes") {
			if(input[i][4]=="No") {
				return false;
			}
			else {
				return false;
			}
		}
		else {
			if(input[i][4]=="No") {
				return false;
			}
			else {
				return false;
			}
		}
	}
	
	else {
		if(input[i][4]=="No") {
			if(input[i][0]=="No") {
				return false;
			}
			else {
				return false;
			}
		}
		else {
			return true;
		}
	}
}

public static boolean tree5(int i,String[][] input ) {
	// Tree 5
	//0				1				2				3				4				5				6			7
	//Pregnancies	Glucose			BloodPressure	SkinThickness	Insulin			BMI				Age			Outcome
	//(> 0 , Yes)	(>110 , Yes)	(>80 , Yes)		(>30 , Yes)		(>150 , Yes)	(>18.5 , Yes)	(>50 , Yes)
	//81%
	
	if(input[i][0]=="Yes") {
		if(input[i][2]=="Yes") {
			if(input[i][1]=="No") {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			if(input[i][3]=="Yes") {
				if(input[i][1]=="No") {
					return false;
				}
				else {
					return false;
				}
			}
			else {
				if(input[i][1]=="No") {
					return false;
				}
				else {
					return false;
				}
			}
		}
	}
	else {
		return false;
	}
		
}

public static boolean tree6(int i,String[][] input ) {		//tree7
	if(input[i][0]=="Yes") {
		if(input[i][4]=="Yes") {
			if(input[i][1]=="Yes") {
				if(input[i][6]=="No") {
					return false;
				}
				else {
					return false;
				}
			}
			else {
				if(input[i][6]=="No") {
					return false;
				}
				else {
					return true;
				}
			}
		}
		else {
			if(input[i][1]=="No") {
				return false;
			}
			else {
				return false;
			}
		}
	}
	else {
		if(input[i][1]=="Yes") {
			return true;
		}
		else {
			return false;
		}
	}
}

public static boolean tree7(int i,String[][] input ) { 		//tree8
	if(input[i][2]=="No") {
		if(input[i][4]=="No") {
			return false;
		}
		else {
			if(input[i][3]=="No") {
				if(input[i][1]=="No") {
					return true;
				}
				else {
					return true;
				}
			}
			else {
				if(input[i][1]=="No") {
					return false;
				}
				else {
					return true;
				}
			}
		}
		
	}
	else {
		if(input[i][3]=="No") {
			if(input[i][1]=="Yes") {
				return true;
			}
			else {
				if(input[i][4]=="No") {
					return false;
				}
				else {
					return false;
				}
			}
		}
		else {
			if(input[i][1]=="No") {
				return true;
			}
			else {
				return false;
			}
		}
	}
}

public static boolean tree8(int i,String[][] input ) {		//tree11
	if(input[i][0]=="Yes") {                   //pregnancies 1
		 if(input[i][6]=="Yes") {              //age 2
			 //System.out.println("Tree 1 :"+"Positive");
			 return true;
		 }
		 else {
			 if(input[i][1]=="Yes") { //type    //glucose 3
				 if(input[i][2]=="Yes") {       //bloodpressure 4
					 if(input[i][4]=="Yes") {   //insulin 12
						 //System.out.println("Tree 1 :"+"Negative"); //13
						 return false;
					 }
					 else {
						 if(input[i][3]=="Yes") {  //skinthickness 14
							 //System.out.println("Tree 1 :"+"Positive"); //16
							 return true;
						 }
						 else {
							 //System.out.println("Tree 1 :"+"Negative"); //15
							 return false;
						 }
					 }
				 }
				 else {
					 if(input[i][3]=="Yes") {     //skinthickness 5
						 if(input[i][4]=="Yes") {  //insulin 9
							 //System.out.println("Tree 1 :"+"Positive"); //10
							 return true;
						 }
						 else {
							 return false;
							 //System.out.println("Tree 1 :"+"Negative"); //11
						 }
					 }
					 else {
						 if(input[i][4]=="Yes") {   //insulin 6
							 return false;
							 //System.out.println("Tree 1 :"+"Negative"); // 7
						 }
						 else {
							 return true;
							 //System.out.println("Tree 1 :"+"Positive"); //8
						 }
					 }
				 }
			 }
			 else {
				 if(input[i][5]=="Yes") { //BMI 17
					 if(input[i][2]=="Yes") {   //bloodpressure 18
						 return false;
						 //System.out.println("Tree 1 :"+"Negative"); //22
					 }
					 else {
						 if(input[i][3]=="Yes") { //skinthickness 19
							 return false;
							 //System.out.println("Tree 1 :"+"Negative"); // 21
						 }
						 else {
							 return false;
							 //System.out.println("Tree 1 :"+"Negative"); //20
						 }
					 }
				 }
				 else {
					 return false;
					 //System.out.println("Tree 1 :"+"Negative"); //23
				 }
			 }
		 }
	}
	else {
		if(input[i][1]=="Yes") {   //glucose 25
			return true;
			//System.out.println("Tree 1 :"+"Positive"); // 26
		}
		else {
			return false;
			//System.out.println("Tree 1 :"+"Negative"); // 27
		}
	}
}

public static boolean tree9(int i,String[][] input ) {		//tree12
	if(input[i][6]=="Yes") {
		return true;
		//System.out.println("Tree 2 :"+"Positive");
	}
	else {
		if(input[i][2]=="Yes") {
			return true;
			//System.out.println("Tree 2 :"+"Positive");
		}
		else {
			if(input[i][4]=="Yes") {
				if(input[i][0]=="Yes") {
					if(input[i][3]=="Yes") {
						return false;
						//System.out.println("Tree 2 :"+"Negative");
					}
					else {
						if(input[i][1]=="Yes") {
							return true;
							//System.out.println("Tree 2 :"+"Positive");
						}
						else {
							return false;
							//System.out.println("Tree 2 :"+"Negative");
						}
					}
				}
				else {
					if(input[i][1]=="Yes") {
						return true;
						//System.out.println("Tree 2 :"+"Positive");
					}
					else {
						return false;
						//System.out.println("Tree 2 :"+"Negative");
					}
				}
			}
			else {
				if(input[i][1]=="Yes") {
					if(input[i][0]=="Yes") {
						return false;
						//System.out.println("Tree 2 :"+"Negative");
					}
					else {
						return true;
						//System.out.println("Tree 2 :"+"Positive");
					}
				}
				else {
					return false;
					//System.out.println("Tree 2 :"+"Negative");
				}
			}
		}
	}
}

public static boolean tree10(int i,String[][] input ) {		//tree13
	if(input[i][4]=="Yes") {
		if(input[i][0]=="Yes") {
			if(input[i][6]=="Yes") {
				return true;
				//System.out.println("Tree 3 :"+"Positive");
			}
			else {
				if(input[i][2]=="Yes") {
					if(input[i][3]=="Yes") {
						return true;
						//System.out.println("Tree 3 :"+"Positive");
					}
					else {
						return false;
						//System.out.println("Tree 3 :"+"Negative");
					}
				}
				else {
					if(input[i][3]=="Yes") {
						if(input[i][1]=="Yes") {
							return true;
							//System.out.println("Tree 3 :"+"Positive");
						}
						else {
							return true;
							//System.out.println("Tree 3 :"+"Positive");
						}
					}
					else {
						return true;
						//System.out.println("Tree 3 :"+"Positive");
					}
				}
			}
		}
		else {
			return false;
			//System.out.println("Tree 3 :"+"Negative");
		}
	}
	else {
		if(input[i][0]=="Yes") {
			if(input[i][6]=="Yes") {
				if(input[i][3]=="Yes") {
					return true;
					//System.out.println("Tree 3 :"+"Positive");
				}
				else {
					return false;
					//System.out.println("Tree 3 :"+"Negative");
				}
			}
			else {
				if(input[i][1]=="Yes") {
					return false;
					//System.out.println("Tree 3 :"+"Negative");
				}
				else {
					if(input[i][3]=="Yes") {
						return false;
						//System.out.println("Tree 3 :"+"Negative");
					}
					else {
						return false;
						//System.out.println("Tree 3 :"+"Negative");
					}
				}
			}
		}
		else {
			return true;
			//System.out.println("Tree 3 :"+"positive");
		}
	}
	
}	



static void findMajority(Boolean [] majority, int n)
{
    int maxCount = 0;
    int index = -1; // sentinels
    for (int i = 0; i < n; i++) {
        int count = 0;
        for (int j = 0; j < n; j++) {
            if (majority[i] == majority[j])
                count++;
        }

        // update maxCount if count of
        // current element is greater
        if (count > maxCount) {
            maxCount = count;
            index = i;
        }
    }

    // if maxCount is greater than n/2
    // return the corresponding element
    if (maxCount > n / 2)
        System.out.println("Does the patient has diabetes? - "+ majority[index]);

    else
        System.out.println("No Majority Element");
}


public static boolean randomeThreeMax(Boolean[] majority) {
	 
	List<Boolean> list = Arrays.asList(majority);
	
	Iterator<Boolean> ite = list.iterator();
	
//	while (ite.hasNext()) {
//		boolean bs =  ite.next();
//		System.out.print(bs + "\t");
//	}
//	System.out.println();
	
	Collections.shuffle(list);
	
	Iterator<Boolean> site = list.iterator();
	
//	while (site.hasNext()) {
//		boolean bs =  site.next();
//		System.out.print(bs + "\t");
//	}
	
	
	Boolean[] resrandomthree = {list.get(0) , list.get(1) , list.get(2)};
	
	int truecount = 0;
	int falsecount = 0;
	for(Boolean b : resrandomthree) {
		if(b==true) {
			truecount++;
		}else {
			falsecount++;
		}
	}
	
	
//	System.out.println("True Count " + truecount + " The False Count  " + falsecount);		
	return  truecount > falsecount ;
}


public static String [][] Read_Excel_Data(){
	
	File file = new File("C:\\Users\\sahanbcs\\Downloads\\test.xlsx");
	
	XSSFWorkbook wkbook;
	XSSFSheet sheet;
	String [][] arr = new String[10][10];
	
	try {
		FileInputStream excel = new FileInputStream(file);
		wkbook = new XSSFWorkbook(excel);
		sheet = wkbook.getSheet("filtered dataset - Test set");
		int start = sheet.getFirstRowNum()+3;
		int end = sheet.getLastRowNum();
		arr = new String[end-start+1][8];
		for(int k = 0 , i = start; i <= end; i++ ,k++) {
			arr[k][0] = sheet.getRow(i).getCell(0).getStringCellValue();
			arr[k][1] = sheet.getRow(i).getCell(1).getStringCellValue();
			arr[k][2] = sheet.getRow(i).getCell(2).getStringCellValue();
			arr[k][3] = sheet.getRow(i).getCell(3).getStringCellValue();
			arr[k][4] = sheet.getRow(i).getCell(4).getStringCellValue();
			arr[k][5] = sheet.getRow(i).getCell(5).getStringCellValue();
			arr[k][6] = sheet.getRow(i).getCell(6).getStringCellValue();
			arr[k][7] = sheet.getRow(i).getCell(7).getStringCellValue();
		}
		
	} catch(IOException e) {
		System.out.println(e.getMessage());
	}
	
	return arr;
}


}
