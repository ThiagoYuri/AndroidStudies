package ws.android.atividadeeintencao;

//Primeiro importe dois pacotes
//vaos agora EOÇAO
   ///Loja - (Performace) - Avalicçao *****
   //Parcelable


import android.os.Parcel;
import android.os.Parcelable;

public class Cliente implements Parcelable {

    //codigo é de instancia (no-static)
private int codigo;
private String nome;
private static int cont = 0;

//Declaração comm parametros
public Cliente(int codigo,String nome ){
    this.codigo = codigo;
    this.nome = nome;
    cont++;
}

//Construtor com parametro Parcel (Serialização)
public Cliente(Parcel from){
    codigo = from.readInt(); // Ler os bytes e passa para o atributo codigo
    nome = from.readString(); // Ler os bytes e passa para o atributo nome
}
   //Creator e eum constate (Static Final)
   //constante do tipo Parcelable.Creator
   //Todas as classes que implementao o Parcelable devem conter esse atributo
   //Ela e responsavel por criar o objeto a partir de um Parcel para deserializar estte.
   public static final Parcelable.Creator<Cliente> CREATOR = new Parcelable.Creator<Cliente>(){


       /**
        * Create a new instance of the Parcelable class, instantiating it
        * from the given Parcel whose data had previously been written by
        //* {@link Parcelable#writeToParcel Parcelable.writeToParcel()}.
        *
       // * @param source The Parcel to read the object's data from.
        * @return Returns a new instance of the Parcelable class.
        */

       //Chama o construor de classe Cliente
       //Como paremetro ele passa o parametro in
       @Override
       public Cliente createFromParcel(Parcel in) {
           return new Cliente((in)); //Criar o objeto
       }

       /**
        * Create a new array of the Parcelable class.
        *
        * @param size Size of the array.
        * @return Returns an array of the Parcelable class, with every entry
        * initialized to null.
        */
       @Override
       public Cliente[] newArray(int size) {
           return new Cliente[0];
       }
   };

    /**
     * Describe the kinds of special objects contained in this Parcelable
     * instance's marshaled representation. For example, if the object will
     * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
     * the return value of this method must include the
     * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
     *
     * @return a bitmask indicating the set of special object types marshaled
     * by this Parcelable object instance.
     */

    //inteiro que servira como identificador unico nessa classes.
     //dicar: *Cada class do seu projeto deve possuir um indentificador unico*
    @Override
    public int describeContents() {
        return 0; // numero inteiro
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */

    //Esse metodo
       //writeToParcel
         //*Serializar(trantoforma em bytes) os atributos
    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(codigo);
        dest.writeString(nome);
    }


    public static int getCont() {
        return cont;
    }

}

