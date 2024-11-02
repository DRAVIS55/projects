try{
            new Finance().setVisible(true);
            }
            catch(IOException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "error loading main method: "+e,"erro1:", JOptionPane.ERROR_MESSAGE);
            }