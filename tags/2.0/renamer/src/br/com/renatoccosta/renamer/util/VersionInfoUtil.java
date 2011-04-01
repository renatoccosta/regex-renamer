/*
 *  Copyright 2011 Renato Couto da Costa.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */
package br.com.renatoccosta.renamer.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 *
 * @author Renato Costa
 */
public class VersionInfoUtil {

    private static ResourceBundle bundle = ResourceBundle.getBundle(
            "version-info");

    public static int getMajorVersion() {
        return Integer.parseInt(bundle.getString("version.major"));
    }

    public static int getMinorVersion() {
        return Integer.parseInt(bundle.getString("version.minor"));
    }

    public static int getBuildNumber() {
        return Integer.parseInt(bundle.getString("version.build"));
    }

    public static String getVersionNumber() {
        return getMajorVersion() + "." + getMinorVersion() + "."
                + getBuildNumber();
    }

    public static Date getVersionDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        try {
            return sdf.parse(bundle.getString("version.date"));
        } catch (ParseException ex) {
            return null;
        }
    }

}
