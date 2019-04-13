package Model;

/**
 * Copyright (C) 2019  Moritz Herzog
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>
 */

import Enumerations.BodyRegion;
import Enumerations.ExerciseType;
import Enumerations.Intensities;
import Enumerations.TrainingsTypes;
import Exceptions.ScheduleAvailableException;
import Exercise.BodyWeightExercise;
import Exercise.DeviceExercise;
import Exercise.Exercise;
import Exercise.WarmUpExercise;
import Schedule.Schedule;

import org.omg.CORBA.DynAnyPackage.Invalid;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.io.IOException;

public class XMLParser {
    // Application
    static final String ROOT_ID = "trainingsschedule";
    // Schedules
    static final String SCHEDULE_ID = "schedule";
    static final String SCHEDULE_NAME_TAG = "name";
    static final String SCHEDULE_REPETITIONS_TAG = "repetitions";
    static final String SCHEDULE_PAUSETIME_TAG = "pause";
    static final String SCHEDULE_SETS_TAG = "sets";
    static final String SCHEDULE_SPEED_TAG = "speed";
    static final String SCHEDULE_TRAININGSTYPE_TAG = "trainingstype";
    static final String SCHEDULE_COLOR_TAG = "color";
    //Exercise
    static final String EXCERCISE_ID = "exercise";
    static final String EXCERCISE_NAME_TAG = "name";
    static final String EXCERCISE_TYPE_TAG = "type";
    static final String EXCERCISE_POSITION_TAG = "position";
    static final String EXCERCISE_BODY_REGION = "bodyregion";
    // WarmUpExercise
    static final String EXCERCISE_EXECUTIONTIME_TAG = "executiontime";
    static final String EXCERCISE_INTENSITY_TAG = "intensity";
    static final String EXCERCISE_SUBINTENSITY_TAG = "subintensity";
    static final String EXCERCISE_BPM_TAG = "bpm";
    // BodyWeightExercise
    static final String EXCERCISE_ADDITIONALINFORMATION_TAG = "additionalinformation";
    // DeviceExercise
    static final String EXCERCISE_SEAT_TAG = "seat";
    static final String EXCERCISE_LEG_TAG = "leg";
    static final String EXCERCISE_FOOT_TAG = "foot";
    static final String EXCERCISE_ANGLE_TAG = "angle";
    static final String EXCERCISE_WEIGHT_TAG = "weight";
    static final String EXCERCISE_ADDITIONALWEIGHT_TAG = "additionalweight";
    static final String EXCERCISE_BACK_TAG = "BACK";
    static final String EXCERCISE_DEVICENUMBER_TAG = "devicenumber";
    private Model ApplicationModel = null;

    /**
     * Constructor
     *
     * @param model Model to save the Data
     */
    public XMLParser(Model model) {
        ApplicationModel = model;
    }

    /**
     * Parses the given file.
     *
     * @param readableFile
     * @return
     */
    public boolean parseFile(File readableFile) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(readableFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName(SCHEDULE_ID);
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String name = element.getAttribute(SCHEDULE_NAME_TAG);
                    Schedule schedule = new Schedule(name);
                    if (!element.getAttribute(SCHEDULE_TRAININGSTYPE_TAG).isEmpty())
                        schedule.setTrainingsType(TrainingsTypes.valueOf(element.getAttribute(SCHEDULE_TRAININGSTYPE_TAG)));
                    schedule.setPauseTime(Integer.valueOf(element.getAttribute(SCHEDULE_PAUSETIME_TAG)));
                    schedule.setRepetitions(Integer.valueOf(element.getAttribute(SCHEDULE_REPETITIONS_TAG)));
                    schedule.setSets(Integer.valueOf(element.getAttribute(SCHEDULE_SETS_TAG)));
                    schedule.setSpeed(Integer.valueOf(element.getAttribute(SCHEDULE_SPEED_TAG)));

                    if (!element.getAttribute(SCHEDULE_COLOR_TAG).isEmpty())
                        schedule.setScheduleColor(Integer.valueOf(element.getAttribute(SCHEDULE_COLOR_TAG)));

                    NodeList nodeList1 = element.getElementsByTagName(EXCERCISE_ID);

                    for (int j = 0; j < nodeList1.getLength(); j++) {
                        Node node2 = nodeList1.item(j);
                        if (node2.getNodeType() == Node.ELEMENT_NODE) {
                            Element element1 = (Element) node2;
                            String excName = element1.getAttribute(EXCERCISE_NAME_TAG);
                            ExerciseType type = ExerciseType.valueOf(element1.getAttribute(EXCERCISE_TYPE_TAG));

                            BodyRegion region = BodyRegion.INVALID;
                            if (!element1.getAttribute(EXCERCISE_BODY_REGION).isEmpty())
                                region = BodyRegion.valueOf(element1.getAttribute(EXCERCISE_BODY_REGION));

                            switch (type) {
                                case Device:
                                    DeviceExercise dexc = new DeviceExercise(excName);
                                    dexc.setPosition(Integer.valueOf(element1.getAttribute(EXCERCISE_POSITION_TAG)));
                                    dexc.setStimulatedBodyRegion(region);

                                    int intValue = Integer.valueOf(element1.getAttribute(EXCERCISE_SEAT_TAG));
                                    dexc.setSeatActivated(intValue != Integer.MAX_VALUE);
                                    dexc.setSeatPosition(intValue);

                                    intValue = Integer.valueOf(element1.getAttribute(EXCERCISE_LEG_TAG));
                                    dexc.setLegActivated(intValue != Integer.MAX_VALUE);
                                    dexc.setLegPosition(intValue);

                                    intValue = Integer.valueOf(element1.getAttribute(EXCERCISE_FOOT_TAG));
                                    dexc.setFootActivated(intValue != Integer.MAX_VALUE);
                                    dexc.setFootPosition(intValue);

                                    intValue = Integer.valueOf(element1.getAttribute(EXCERCISE_ANGLE_TAG));
                                    dexc.setAngleActivated(intValue != Integer.MAX_VALUE);
                                    dexc.setAnglePosition(intValue);

                                    double doubleValue = Double.valueOf(element1.getAttribute(EXCERCISE_WEIGHT_TAG));
                                    dexc.setWeightActivated(doubleValue != Double.MAX_VALUE);
                                    dexc.setWeight(doubleValue);

                                    doubleValue = Double.valueOf(element1.getAttribute(EXCERCISE_ADDITIONALWEIGHT_TAG));
                                    dexc.setAdditionalWeightActivated(doubleValue != Double.MAX_VALUE);
                                    dexc.setAdditionalWeight(doubleValue);

                                    intValue = Integer.valueOf(element1.getAttribute(EXCERCISE_BACK_TAG));
                                    dexc.setBackActivated(intValue != Integer.MAX_VALUE);
                                    dexc.setBackPosition(intValue);

                                    intValue = Integer.valueOf(element1.getAttribute(EXCERCISE_DEVICENUMBER_TAG));
                                    dexc.setDeviceNumberActivated(intValue != Integer.MAX_VALUE);
                                    dexc.setDeviceNumber(intValue);

                                    schedule.addExercise(dexc);
                                    break;
                                case BodyWeight:
                                    BodyWeightExercise bexc = new BodyWeightExercise(excName);
                                    bexc.setPosition(Integer.valueOf(element1.getAttribute(EXCERCISE_POSITION_TAG)));
                                    bexc.setStimulatedBodyRegion(region);
                                    String addInformation = element1.getAttribute(EXCERCISE_ADDITIONALINFORMATION_TAG);
                                    bexc.setAdditionalInformationActivated(!addInformation.isEmpty());
                                    bexc.setAdditionalInformation(addInformation);
                                    schedule.addExercise(bexc);
                                    break;
                                case WarmUp:
                                    WarmUpExercise wexc = new WarmUpExercise(excName);
                                    wexc.setPosition(Integer.valueOf(element1.getAttribute(EXCERCISE_POSITION_TAG)));
                                    wexc.setStimulatedBodyRegion(region);

                                    Intensities intensities = Intensities.valueOf(element1.getAttribute(EXCERCISE_INTENSITY_TAG));
                                    wexc.setIntensityActivated(intensities != Intensities.invalid);
                                    wexc.setIntenity(intensities);

                                    int intValue2 = Integer.valueOf(element1.getAttribute(EXCERCISE_EXECUTIONTIME_TAG));
                                    wexc.setExecutionTimeActivated(intValue2 != Integer.MAX_VALUE);
                                    wexc.setExecutionTime(intValue2);

                                    intValue2 = Integer.valueOf(element1.getAttribute(EXCERCISE_SUBINTENSITY_TAG));
                                    wexc.setSubintensityActivated(intValue2 != Integer.MAX_VALUE);
                                    wexc.setSubIntensity(intValue2);

                                    intValue2 = Integer.valueOf(element1.getAttribute(EXCERCISE_BPM_TAG));
                                    wexc.setBPMActivated(intValue2 != Integer.MAX_VALUE);
                                    wexc.setBPM(intValue2);

                                    schedule.addExercise(wexc);
                                    break;
                            }
                        }
                    }

                    ApplicationModel.addSchedule(schedule);
                }
            }

            return true;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            return false;
        } catch (SAXException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (ScheduleAvailableException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean writeFile(File writeableFile) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.newDocument();

            Element rootElement = doc.createElement(ROOT_ID);
            doc.appendChild(rootElement);

            for (Schedule sched : ApplicationModel.getSchedulesList()) {
                Element scheduleElement = doc.createElement(SCHEDULE_ID);

                scheduleElement.setAttribute(SCHEDULE_NAME_TAG, sched.getName());
                scheduleElement.setAttribute(SCHEDULE_TRAININGSTYPE_TAG, sched.getTrainingsType().name());
                scheduleElement.setAttribute(SCHEDULE_REPETITIONS_TAG, String.valueOf(sched.getRepetitions()));
                scheduleElement.setAttribute(SCHEDULE_PAUSETIME_TAG, String.valueOf(sched.getPauseTime()));
                scheduleElement.setAttribute(SCHEDULE_SETS_TAG, String.valueOf(sched.getSets()));
                scheduleElement.setAttribute(SCHEDULE_SPEED_TAG, String.valueOf(sched.getSpeed()));

                if (sched.getScheduleColor() != Integer.MAX_VALUE)
                    scheduleElement.setAttribute(SCHEDULE_COLOR_TAG, String.valueOf(sched.getScheduleColor()));

                for (Exercise exc : sched.exercises()) {
                    Element exerElement = doc.createElement(EXCERCISE_ID);
                    exerElement.setAttribute(EXCERCISE_NAME_TAG, exc.getName());
                    exerElement.setAttribute(EXCERCISE_POSITION_TAG, String.valueOf(exc.getPosition()));
                    exerElement.setAttribute(EXCERCISE_TYPE_TAG, exc.type().name());
                    exerElement.setAttribute(EXCERCISE_BODY_REGION, exc.getStimulatedBodyRegion().name());
                    switch (exc.type()) {
                        case Device:
                            DeviceExercise dexc = (DeviceExercise) exc;
                            exerElement.setAttribute(EXCERCISE_SEAT_TAG, String.valueOf(dexc.getSeatPosition()));
                            exerElement.setAttribute(EXCERCISE_LEG_TAG, String.valueOf(dexc.getLegPosition()));
                            exerElement.setAttribute(EXCERCISE_FOOT_TAG, String.valueOf(dexc.getFootPosition()));
                            exerElement.setAttribute(EXCERCISE_ANGLE_TAG, String.valueOf(dexc.getAnglePosition()));
                            exerElement.setAttribute(EXCERCISE_WEIGHT_TAG, String.valueOf(dexc.getWeight()));
                            exerElement.setAttribute(EXCERCISE_ADDITIONALWEIGHT_TAG, String.valueOf(dexc.getAdditionalWeight()));
                            exerElement.setAttribute(EXCERCISE_BACK_TAG, String.valueOf(dexc.getBackPosition()));
                            exerElement.setAttribute(EXCERCISE_DEVICENUMBER_TAG, String.valueOf(dexc.getDeviceNumber()));
                            break;
                        case BodyWeight:
                            BodyWeightExercise bexc = (BodyWeightExercise) exc;
                            exerElement.setAttribute(EXCERCISE_ADDITIONALINFORMATION_TAG, bexc.getAdditionalInformation());
                            break;
                        case WarmUp:
                            WarmUpExercise wexc = (WarmUpExercise) exc;
                            exerElement.setAttribute(EXCERCISE_EXECUTIONTIME_TAG, String.valueOf(wexc.getExecutionTime()));
                            exerElement.setAttribute(EXCERCISE_INTENSITY_TAG, wexc.getIntenity().name());
                            exerElement.setAttribute(EXCERCISE_SUBINTENSITY_TAG, String.valueOf(wexc.getSubIntensity()));
                            exerElement.setAttribute(EXCERCISE_BPM_TAG, String.valueOf(wexc.getBPM()));
                            break;
                    }

                    scheduleElement.appendChild(exerElement);
                }

                rootElement.appendChild(scheduleElement);

                DOMSource source = new DOMSource(doc);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                StreamResult result = new StreamResult(writeableFile);
                transformer.transform(source, result);
            }

            return true;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            return false;
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
            return false;
        } catch (TransformerException e) {
            e.printStackTrace();
            return false;
        }
    }
}
