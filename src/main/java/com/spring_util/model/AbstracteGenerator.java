/**
 * Copyrigt (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.spring_util.model;

/**
 * @author wuheng@iscas.ac.cn
 * @since 2020.2.10
 * <p>
 * mysqldump -h 172.17.0.2 -u root -p demo user> dbname_users.sql
 */

public abstract class AbstracteGenerator {

    public static final String rootPath = System.getProperty("user.dir");

    protected StringBuffer content = new StringBuffer();

    protected String dir;

    protected String name;

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println(content);
    }

    public void write() throws Exception {
        FileUtils.createFile(rootPath + "/"
                        + dir.replace(".", "/"),
                name, content.toString());
    }
}
