public class JDBCCalls {

    public static void main(String[] args) {

        DAOClass dao = new DAOClass();

        if (args.length == 0) {
            System.out.println("Usage:");
            System.out.println("Insert : 1 rollno name standard dob fees");
            System.out.println("Delete : 2 rollno");
            System.out.println("Modify : 3 rollno fees");
            System.out.println("Display: 4");
            return;
        }

        int choice = Integer.parseInt(args[0]);

        switch (choice) {

            case 1:
                dao.insert(
                        Integer.parseInt(args[1]),
                        args[2],
                        args[3],
                        args[4],
                        Double.parseDouble(args[5]));
                break;

            case 2:
                dao.delete(Integer.parseInt(args[1]));
                break;

            case 3:
                dao.modify(
                        Integer.parseInt(args[1]),
                        Double.parseDouble(args[2]));
                break;

            case 4:
                dao.display();
                break;

            default:
                System.out.println("Invalid Choice");
        }
    }
}