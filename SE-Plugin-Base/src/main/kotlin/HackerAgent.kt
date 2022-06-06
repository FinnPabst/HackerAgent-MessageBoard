import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.entity.Agent
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.entity.Entity
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.simulation.SimulationWorld

//manipulates the message board of the simulation setting the depature Time later than the plane takes off
class HackerAgent : Agent() {


    override fun onBirth() {
        speed = 1.0
    }

    override fun pluginUpdate() {
        super.onBirth()
        val message_list = world.entities.filterIsInstance<messageboard>() // TODO: fill in right object name
        val canMoveTo = Entity::class.java.getDeclaredMethod("canMoveTo").also { it.isAccessible = true }

        var x = 0
        while (x < message_list.size) {
            val messageboard = world.entities.filterIsInstance<messageboard>().firstOrNull() ?: return // TODO: fill in right object name
            val messageBoardPos = messageboard.getposition()
            if ((canMoveTo (this, world as SimulationWorld , messageBoardPos.x, messageBoardPos.y, width, height) as Boolean)) {
                val messageboard = world.entities.filterIsInstance<messageboard>()[2] ?: return // TODO: fill in right object name
                val messageBoardPos = messageboard.getposition
                turn(messageBoardPos)
                if (messageBoardPos .. position < 10) {
                    speed = .0
                    height /= 2
                }
                messageboard.setdeparturetime(getdeparturetime().tolong() + 100) // TODO: specify correct time stamp (unix time stamp?)
                return
            }
            x++
    }



    }

    companion object {
        const val TYPE_ID = "HackerAgent"
    }
}

