package com.german_software_engineers.Presenter.Configuration;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

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
public class ConfigurationParser {

    private final String ROOT_ID = "configuraiton";

    private final String COLOR_ID = "color";
    private final String BODY_EXERCISE_COLOR = "bodycolor";
    private final String ARMS_EXERCISE_COLOR = "armscolor";
    private final String LEGS_EXERCISE_COLOR = "legscolor";

    private String PathToConfiguration = "";
    private Configuration Configuration = null;
    private String ConfigurationFile = "config.xml";

    public ConfigurationParser(Configuration configuration, String pathToconfiguration) {
        PathToConfiguration = pathToconfiguration;
        Configuration = configuration;
    }

    public void parseXML(File configfile) {
        try {
            if (configfile.exists()) {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(configfile);
                doc.getDocumentElement().normalize();

                NodeList elements = doc.getDocumentElement().getElementsByTagName(COLOR_ID);

                for (int i = 0; i < elements.getLength(); i++) {
                    Node node = elements.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        String bodyColorString = element.getAttribute(BODY_EXERCISE_COLOR);
                        if (!bodyColorString.isEmpty())
                            Configuration.setBodyExerciseColor(Integer.valueOf(bodyColorString));

                        String armsColorString = element.getAttribute(ARMS_EXERCISE_COLOR);
                        if (!armsColorString.isEmpty())
                            Configuration.setArmsExerciseColor(Integer.valueOf(armsColorString));

                        String legColorString = element.getAttribute(LEGS_EXERCISE_COLOR);
                        if (!legColorString.isEmpty())
                            Configuration.setLegsExerciseColor(Integer.valueOf(legColorString));
                    }
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeXML(File configfile) {
        try {
            if (!configfile.exists()) {
                configfile.createNewFile();
            }

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.newDocument();

            Element rootElement = doc.createElement(ROOT_ID);
            doc.appendChild(rootElement);

            Element colorElement = doc.createElement(COLOR_ID);
            colorElement.setAttribute(BODY_EXERCISE_COLOR, String.valueOf(Configuration.getBodyExerciseColor()));
            colorElement.setAttribute(LEGS_EXERCISE_COLOR, String.valueOf(Configuration.getLegsExerciseColor()));
            colorElement.setAttribute(ARMS_EXERCISE_COLOR, String.valueOf(Configuration.getArmsExerciseColor()));

            rootElement.appendChild(colorElement);

            DOMSource source = new DOMSource(doc);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StreamResult result = new StreamResult(configfile);
            transformer.transform(source, result);

        } catch (IOException | ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}


