import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MemberManager {

 

        BufferedReader br = new BufferedReader(

                       new InputStreamReader(System.in));

       

        private void execute() {

               StringBuilder menu = new StringBuilder();

               menu.append("*******************\n");

               menu.append("* 1. 전체회원조회 *\n");

               menu.append("* 2. 회원검색     *\n");

               menu.append("* 3. 회원입력     *\n");

               menu.append("* 4. 회원수정     *\n");

               menu.append("* 5. 회원삭제     *\n");

               menu.append("* 6. 나가기       *\n");

               menu.append("*******************\n");

               menu.append("입력 > ");

               while(true) {

                   System.out.print(menu);

                       try {

                              String input = br.readLine();

                              int menuNum = Integer.parseInt(input);

                              switch(menuNum) {

                              case 1:

                                  memberSelectAll();

                                  break;

                                 

                              case 2:

                                  memberSelect();

                                  break;

                                 

                              case 3:

                                  memberInsert();

                                  break;

                                 

                              case 4:

                                  memberUpdate();

                                  break;

                                 

                              case 5:

                                  memberDelete();

                                  break;

                              case 6:

                                      System.out.println("이용해주셔서 감사합니다");

                                      System.exit(0);    // 프로그램 종료 (0:정상종료)

                              }

                       } catch (Exception e) {

                              System.out.println("1 ~ 6 만 입력하세요");

                       }

               }

        }

       

        // menu 1. 전체 회원 조회

        public void memberSelectAll() throws IOException, NumberFormatException {

        try (

            Connection conn = MyConn.getConnection();

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("select no,name,age,decode(gender,'0','여자','1','남자'),hdate from member");

        ) {

            System.out.printf("%4s %6s %4s %4s %14s \n", "번호", "회원명", "나이", "성별", "가입일");

            int count=0;

            while(rs.next()) {

                System.out.printf("%4s %8s %6s %4s %24s \n",

                        rs.getString(1),

                        rs.getString(2),

                        rs.getString(3),

                        rs.getString(4),

                        rs.getString(5));   

                count++;

            }

            System.out.println("이상 " + count + "명의 회원이 있습니다.");

        } catch (SQLException e) {

            e.printStackTrace();

        }

        }//end memberSelectAll()

       

        // menu 2. 회원 검색

        public void memberSelect() throws IOException, NumberFormatException {

            System.out.print("이름 > ");

        String input = br.readLine();

            try (

                    Connection conn = MyConn.getConnection();

                    Statement stmt = conn.createStatement();

                    ResultSet rs = stmt.executeQuery("select no,name,age,decode(gender,'0','여자','1','남자'),hdate from member where name like '%"+ input +"%'");

                ) {

                    System.out.printf("%4s %6s %4s %4s %14s \n", "번호", "회원명", "나이", "성별", "가입일");

                    int count=0;

                    while(rs.next()) {

                        System.out.printf("%4s %8s %6s %4s %24s \n",

                                rs.getString(1),

                                rs.getString(2),

                                rs.getString(3),

                                rs.getString(4),

                                rs.getString(5));   

                        count++;

                    }

                   

                    System.out.println("이상 " + count + "명의 회원이 검색되었습니다.");

                } catch (SQLException e) {

                    e.printStackTrace();

                }

        }//end memberSelect()

       

        // menu 3. 회원 입력

        public void memberInsert() throws IOException, NumberFormatException {

            System.out.print("이름 > ");

        String name = br.readLine();

        System.out.print("나이 > ");

        String age = br.readLine();

        System.out.print("성별(0:여자, 1:남자) > ");

        String gender = br.readLine();

       

        try (

            Connection conn = MyConn.getConnection();

            Statement stmt = conn.createStatement();

        ) {

            int result = stmt.executeUpdate("insert into member(no,name,age,gender) " +

                       "values(seq_member.nextval,'"+name+"',"+age+","+gender+")");

            if(result > 0)

                System.out.println("입력되었습니다.");

            else

                System.out.println("입력불가.");

        } catch (SQLException e) {

           

            e.printStackTrace();

        }

        }//end memberInsert()

 

        // menu 4. 회원 수정

        public void memberUpdate() throws IOException, NumberFormatException {

            System.out.print("번호 > ");

        String input = br.readLine();

        System.out.print("이름 > ");

        String name = br.readLine();

        System.out.print("나이 > ");

        String age = br.readLine();

        System.out.print("성별(0:여자, 1:남자) > ");

        String gender = br.readLine();

       

        try (

            Connection conn = MyConn.getConnection();

            Statement stmt = conn.createStatement();

        ) {

            int result = stmt.executeUpdate("update member set name='"+ name +"', age="+ age +", gender="+ gender +" where no = "+ input);

            if(result > 0)

                System.out.println("수정되었습니다.");

            else

                System.out.println("없는 번호입니다.");

        } catch (SQLException e) {

           

            e.printStackTrace();

        }

        }//end memberUpdate()

 

        // menu 5. 회원 삭제

    private void memberDelete() throws IOException, NumberFormatException {

        System.out.print("삭제할 회원번호 > ");

        String input = br.readLine();

        int no = Integer.parseInt(input);

        try (

            Connection conn = MyConn.getConnection();

            Statement stmt = conn.createStatement();

        ) {

            int result = stmt.executeUpdate("delete member where no = " + no);

            if(result > 0)

                System.out.println("삭제되었습니다.");

            else

                System.out.println("없는 번호입니다.");

        } catch (SQLException e) {

           

            e.printStackTrace();

        }

    }//end memberDelete()

       

        public static void main(String[] args) {

               new MemberManager().execute();

        }

 

 

}

 



