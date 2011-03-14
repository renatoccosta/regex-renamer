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
package br.com.renatoccosta.renamer;

import org.apache.commons.lang.StringUtils;

/**
 * Bean class that contains a reference to a file with it's actual name and new
 * name (after renaming)
 *
 * @author Renato Costa
 */
public class RenamedFile {

    private String fileNameBefore;

    private String fileNameAfter;

    private String root;

    public RenamedFile(String fileNameBefore, String root) {
        this.fileNameBefore = fileNameBefore;
        this.root = root;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getFileNameBefore() {
        return fileNameBefore;
    }

    public void setFileNameBefore(String fileNameBefore) {
        this.fileNameBefore = fileNameBefore;
    }

    public String getFileNameAfter() {
        return fileNameAfter == null ? fileNameBefore : fileNameAfter;
    }

    public void setFileNameAfter(String fileNameAfter) {
        this.fileNameAfter = fileNameAfter;
    }

    public String getRelativeFileNameBefore() {
        return StringUtils.difference(root, getFileNameBefore());
    }

    public String getRelativeFileNameAfter() {
        return StringUtils.difference(root, getFileNameAfter());
    }

    /**
     * Indicates if this file should be renamed.
     * @return True if the before and after names are different.
     */
    public boolean shouldRename() {
        return !getFileNameBefore().equals(getFileNameAfter());
    }

}
