import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Unique_Email_file {

    /**
    If you add periods ('.') between some characters in the local name part of an email address,
    mail sent there will be forwarded to the same address without dots in the local name.
    For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
    (Note that this rule does not apply for domain names.)

    If you add a plus ('+') in the local name, everything after the first plus sign will be ignored.
    This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.
    (Again, this rule does not apply for domain names.)

     */

    public static int uniqueEmailFile(String[] emails){

        String DOT_SIGN = ".";
        String PLUS_SIGN = "+";
        String AT_SIGN = "@";

        ArrayList<String>  filteredList = new ArrayList<>();

        for(int i=0; i<emails.length; i++){
            String currStr = emails[i];
            String filteredStr;
            StringBuilder filteredStrBuild = new StringBuilder();
            int lastIndex = 0;

            //index of first "." in email
            int DOT_INDEX = currStr.indexOf(DOT_SIGN);

            //index of first "+" in email
            int PLUS_INDEX = currStr.indexOf(PLUS_SIGN);

            //local name and domain name are separated by "@", so i assumed one email could only have one "@"
            int AT_INDEX = currStr.indexOf(AT_SIGN);

            //if the first "+" is on the left side of the first "."
            if(PLUS_INDEX == -1 || PLUS_INDEX > AT_INDEX){
                //situation that "+" does not exists;
                // in case of "+" exists in the domain name

                if(DOT_INDEX == -1 || DOT_INDEX > AT_INDEX){
                    //situation of "." does not exist in the local name
                    //if the "." exists in the domain name, ignore
                    filteredStr = currStr;
                }else{
                    //situation of "." exist(s) in the local name
                    while(DOT_INDEX < AT_INDEX){
                        //remove all ".' in the local name
                        filteredStrBuild.append(currStr.substring(lastIndex, DOT_INDEX));
                        lastIndex = DOT_INDEX + 1;
                        DOT_INDEX = currStr.indexOf(lastIndex, DOT_INDEX);
                    }
                    filteredStrBuild.append(currStr.substring(AT_INDEX));
                    filteredStr = filteredStrBuild.toString();
                }
            }else{
                //situation that "+" exist(s) in the local name

                if(DOT_INDEX == -1 || DOT_INDEX > AT_INDEX){
                    //situation of "." does not exist in the local name
                    //if the "." exists in the domain name, ignore
                    filteredStrBuild.append(currStr.substring(0, PLUS_INDEX));
                    filteredStrBuild.append(currStr.substring(AT_INDEX));
                    filteredStr = filteredStrBuild.toString();
                }else{
                    //situation of "." exist(s) in the local name
                    String localName = currStr.substring(0, AT_INDEX);
                    localName = localName.substring(0, PLUS_INDEX);

                    DOT_INDEX = localName.indexOf(DOT_SIGN);
                    if(DOT_INDEX == -1){
                        filteredStrBuild.append(localName);
                    }else{
                        while((DOT_INDEX != -1) && (DOT_INDEX < localName.length())){
                            //remove all "." in the local name before PLUS_INDEX
                            filteredStrBuild.append(localName.substring(lastIndex, DOT_INDEX));
                            lastIndex = DOT_INDEX + 1;
                            DOT_INDEX = localName.indexOf(lastIndex, DOT_INDEX);
                        }
                    }

                    filteredStrBuild.append(currStr.substring(AT_INDEX));
                    filteredStr = filteredStrBuild.toString();
                }
            }

            if(filteredList.indexOf(filteredStr) == -1){
                filteredList.add(filteredStr);
                System.out.println("ori: " + currStr + " filtered: " + filteredStr);
            }
        }

        for(int i=0; i<filteredList.size(); i++){
            System.out.println(filteredList.get(i));
        }

        return filteredList.size();
    }

    public static int uniqueEmailFile2(String[] emails){
        Set<String> seen = new HashSet();
        for (String email: emails) {
            int i = email.indexOf('@');
            String local = email.substring(0, i);
            String rest = email.substring(i);
            if (local.contains("+")) {
                local = local.substring(0, local.indexOf('+'));
            }
            local = local.replaceAll(".", "");
            seen.add(local + rest);
        }

        return seen.size();
    }

    public static void main(String[] args){

        //test example
        String[] inputList = {"test.email+alex@leetcode.com",
                                "test.e.mail+bob.cathy@leetcode.com",
                                "testemail+david@lee.tcode.com"};

        String[] inputList2 = {"j+ezsorqlmc@rfpycgjuf.com",
                "j+k+ri+rigt.ad@rfpycgjuf.com",
                "hfmeqzk.isx+i@fiidmdrsu.com",
                "j+p+h+d+d+p+z.j.k.g@rfpycgjuf.com",
                "zygekdy.l.w+s@snh.owpyu.com",
                "j+m.l+ia+qdgv+w@rfpycgjuf.com",
                "r+hwbjwefkp@wcjaki.n.com",
                "zygekdy.l.w+d@snh.owpyu.com",
                "bizdm+sz.f.a.k@il.cjjlp.com",
                "hfmeqzk.isx+t@fiidmdrsu.com",
                "hfmeqzk.isx+i@fiidmdrsu.com",
                "bizdm+f+j+m.l.l@il.cjjlp.com",
                "zygekdy.l.w+g@snh.owpyu.com",
                "r+evgvxmksf@wcjaki.n.com",
                "hfmeqzk.isx+h@fiidmdrsu.com",
                "bizdm+lov+cy@il.cjjlp.com",
                "hfmeqzk.isx+o@fiidmdrsu.com",
                "bizdm+hs+qao@il.cjjlp.com",
                "r+v+z+rcuznrj@wcjaki.n.com",
                "j+r.kn+h.w.a.h+bh@rfpycgjuf.com",
                "hfmeqzk.isx+t@fiidmdrsu.com",
                "hfmeqzk.isx+a@fiidmdrsu.com",
                "zygekdy.l.w+o@snh.owpyu.com",
                "zygekdy.l.w+i@snh.owpyu.com",
                "r+vy.u.y+f.er+aw@wcjaki.n.com",
                "zygekdy.l.w+c@snh.owpyu.com",
                "bizdm+wztzg@il.cjjlp.com",
                "j+h.fwbsr+chp@rfpycgjuf.com",
                "zygekdy.l.w+s@snh.owpyu.com",
                "zygekdy.l.w+d@snh.owpyu.com",
                "bizdm+qq.o.q+p@il.cjjlp.com",
                "zygekdy.l.w+o@snh.owpyu.com",
                "j+c+zqbq+h.dyt@rfpycgjuf.com",
                "r+hl.b.i+fz.hz.t@wcjaki.n.com",
                "r+cbabpf.k+w+e@wcjaki.n.com"};

        for(int i=0; i<inputList.length; i++){
            System.out.println(inputList[i]);
        }

        System.out.println("\n\nRESULT: ");

        System.out.println(uniqueEmailFile2(inputList));
    }
}
