package com.abhi.crickgo.algo;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.transform.sax.SAXSource;

import org.dmg.pmml.FieldName;
import org.dmg.pmml.PMML;
import org.dmg.pmml.TreeModel;
import org.jpmml.evaluator.FieldValue;
import org.jpmml.evaluator.ModelEvaluator;
import org.jpmml.evaluator.NodeScoreDistribution;
import org.jpmml.evaluator.TreeModelEvaluator;
import org.jpmml.model.ImportFilter;
import org.jpmml.model.JAXBUtil;
import org.xml.sax.InputSource;

public class DTreePredictor {

	static PMML model = null;
	static ModelEvaluator<TreeModel> modelEvaluator;

	public static String getPredictionForPlayer(String playerName,
			String againstTeam, String ground, String chasing) {
		String score = "";
		String fileName = "";
		try {
			if (playerName.toLowerCase().contains("virat")) {
				fileName = "Virat_Kohli.pmml";
			} else if (playerName.toLowerCase().contains("ajinkya")) {
				fileName = "Ajinkya_Rahane.pmml";
			} else if (playerName.toLowerCase().contains("ashton")) {
				fileName = "Ashton_Agar.pmml";
			} else if (playerName.toLowerCase().contains("axar")) {
				fileName = "Axar.pmml";
			} else if (playerName.toLowerCase().contains("kumar")) {
				fileName = "B_Kumar.pmml";
			} else if (playerName.toLowerCase().contains("bumrah")) {
				fileName = "Bumrah.pmml";
			} else if (playerName.toLowerCase().contains("coulter")) {
				fileName = "COULTER_NILE.pmml";
			} else if (playerName.toLowerCase().contains("cummins")) {
				fileName = "cummins.pmml";
			} else if (playerName.toLowerCase().contains("david")) {
				fileName = "david.pmml";
			} else if (playerName.toLowerCase().contains("dinesh")) {
				fileName = "Dinesh_Karthik.pmml";
			} else if (playerName.toLowerCase().contains("finch")) {
				fileName = "finch.pmml";
			} else if (playerName.toLowerCase().contains("hazlewood")) {
				fileName = "hazlewood.pmml";
			}
			else if (playerName.toLowerCase().contains("head")) {
				fileName = "Head.pmml";
			}
			else if (playerName.toLowerCase().contains("hilton")) {
				fileName = "hilton.pmml";
			} else if (playerName.toLowerCase().contains("faulknar")) {
				fileName = "JAMES_FAULKNAR.pmml";
			} else if (playerName.toLowerCase().contains("rahul")) {
				fileName = "K_L_Rahul.pmml";
			} else if (playerName.toLowerCase().contains("kedar")) {
				fileName = "Kedar_Jadhav.pmml";
			} else if (playerName.toLowerCase().contains("ken")) {
				fileName = "KEN_RICHARDSON.pmml";
			} else if (playerName.toLowerCase().contains("kuldeep")) {
				fileName = "Kuldeep_Y.pmml";
			} else if (playerName.toLowerCase().contains("shami")) {
				fileName = "M_Shami.pmml";
			} else if (playerName.toLowerCase().contains("manish")) {
				fileName = "Manish_Pandey.pmml";
			} else if (playerName.toLowerCase().contains("maxwell")) {
				fileName = "maxwell.pmml";
			} else if (playerName.toLowerCase().contains("mmarsh")) {
				fileName = "mmarsh.pmml";
			} else if (playerName.toLowerCase().contains("dhoni")) {
				fileName = "MS_Dhoni.pmml";
			} else if (playerName.toLowerCase().contains("pandya")) {
				fileName = "Pandya.pmml";
			} else if (playerName.toLowerCase().contains("peter")) {
				fileName = "PETER_HANDSCOMB.pmml";
			} else if (playerName.toLowerCase().contains("ashwin")) {
				fileName = "R_Ashwin.pmml";
			} else if (playerName.toLowerCase().contains("jadeja")) {
				fileName = "Ravindra_Jadeja.pmml";
			} else if (playerName.toLowerCase().contains("rohit")) {
				fileName = "Rohit_Sharma.pmml";
			} else if (playerName.toLowerCase().contains("shaun")) {
				fileName = "SHAUN_MARSH.pmml";
			} else if (playerName.toLowerCase().contains("shikhar")) {
				fileName = "Shikhar_Dhawan.pmml";
			} else if (playerName.toLowerCase().contains("iyer")) {
				fileName = "Shreyas_Iyer.pmml";
			} else if (playerName.toLowerCase().contains("starc")) {
				fileName = "Starc.pmml";
			} else if (playerName.toLowerCase().contains("smith")) {
				fileName = "STEVEN_SMITH.pmml";
			} else if (playerName.toLowerCase().contains("stoinnis")) {
				fileName = "stoinnis.pmml";
			} else if (playerName.toLowerCase().contains("tim")) {
				fileName = "tim.pmml";
			} else if (playerName.toLowerCase().contains("umesh")) {
				fileName = "Umesh_Yadav.pmml";
			} else if (playerName.toLowerCase().contains("wade")) {
				fileName = "wade.pmml";
			} else if (playerName.toLowerCase().contains("chahal")) {
				fileName = "Yuzvendra_Chahal.pmml";
			} else if (playerName.toLowerCase().contains("zampa")) {
				fileName = "zampa.pmml";
			} else if (playerName.toLowerCase().contains("benjamin")) {
				fileName = "BENJAMIN_STOKES.pmml";
			} else if (playerName.toLowerCase().contains("root")) {
				fileName = "JOSEPH_ROOT.pmml";
			} else if (playerName.toLowerCase().contains("woakes")) {
				fileName = "CHRISTOPHER_WOAKES.pmml";
			} else if (playerName.toLowerCase().contains("ball")) {
				fileName = "JACOB_BALL.pmml";
			} else if (playerName.toLowerCase().contains("buttler")) {
				fileName = "JOSEPH_BUTTLER.pmml";
			} else if (playerName.toLowerCase().contains("plunkett")) {
				fileName = "LIAM_PLUNKETT.pmml";
				
			} else if (playerName.toLowerCase().contains("ali")) {
				fileName = "Moeen_Ali.pmml";
			}

			else if (playerName.toLowerCase().contains("markram")) {
				fileName = "Aiden_Markram.pmml";
			}

			else if (playerName.toLowerCase().contains("elgar")) {
				fileName = "DEAN_ELGAR.pmml";
			}

			else if (playerName.toLowerCase().contains("faf")) {
				fileName = "FAF.pmml";
			}

			else if (playerName.toLowerCase().contains("imran")) {
				fileName = "IMRAN_TAHIR.pmml";
			}

			else if (playerName.toLowerCase().contains("klaasen")) {
				fileName = "KLAASEN.pmml";
			}

			else if (playerName.toLowerCase().contains("morris")) {
				fileName = "MORRIS.pmml";
			} else if (playerName.toLowerCase().contains("rabada")) {
				fileName = "RABADA.pmml";
			}

			else if (playerName.toLowerCase().contains("philander")) {
				fileName = "VERNON_PHILANDER.pmml";
			} else if (playerName.toLowerCase().contains("parnell")) {
				fileName = "WAYNEPARNELL.pmml";
			}
			String filePath = "./model/" + fileName;
			InputStream is = new FileInputStream(new File(filePath));
			InputSource source = new InputSource(is);
			SAXSource transformedSource = ImportFilter.apply(source);
			model = JAXBUtil.unmarshalPMML(transformedSource);
			modelEvaluator = new TreeModelEvaluator(model);
			Map<FieldName, FieldValue> paramMap = new LinkedHashMap<FieldName, FieldValue>();
			addStringParam(paramMap, "opposite_team", againstTeam);
			addStringParam(paramMap, "ground", ground);
			addStringParam(paramMap, "chasing", chasing);
			Map<FieldName, ?> results = modelEvaluator.evaluate(paramMap);
			FieldName targetName = modelEvaluator.getTargetField();
			NodeScoreDistribution targetValue = (NodeScoreDistribution) results
					.get(targetName);
			score = (String) targetValue.getResult();
			is.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return score;

	}

	/*
	 * public static void main(String[] args) throws FileNotFoundException,
	 * JAXBException, SAXException { String score =
	 * getPredictionForPlayer("virat", "Australia", "Manuka Oval", "false");
	 * System.out.println(score);
	 * 
	 * }
	 */

	public static void addIntParam(Map<FieldName, FieldValue> paramMap,
			String fieldNameStr, int fieldValueInt) {
		FieldName fn = new FieldName(fieldNameStr);
		FieldValue fv = modelEvaluator.prepare(fn, fieldValueInt);
		paramMap.put(fn, fv);
	}

	public static void addStringParam(Map<FieldName, FieldValue> paramMap,
			String fieldNameStr, String fieldValueString) {
		FieldName fn = new FieldName(fieldNameStr);
		FieldValue fv = modelEvaluator.prepare(fn, fieldValueString);
		paramMap.put(fn, fv);
	}

}
