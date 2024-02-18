import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myagenda.R
import com.example.myagenda.clases.Persona

class ContactosAdapter(private val listaContactos: List<Persona>) : RecyclerView.Adapter<ContactosAdapter.ContactoViewHolder>() {

    inner class ContactoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val datosTextView: TextView = itemView.findViewById(R.id.datosTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_contacto, parent, false)
        return ContactoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContactoViewHolder, position: Int) {
        val currentItem = listaContactos[position]
        holder.datosTextView.text = "${currentItem.id}, ${currentItem.nombre}, ${currentItem.telefono}, ${currentItem.email}"
    }

    override fun getItemCount(): Int {
        return listaContactos.size
    }
}
