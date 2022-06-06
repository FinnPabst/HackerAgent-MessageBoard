import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.AirportAgentSimulation
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.config.ConfigurableAttribute
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.config.ConfigurationFormatException
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.plugin.Plugin

class HackerPlugin : Plugin {

    override fun activate() {
        println("[${javaClass.simpleName}] Hello World!")

        try {
            AirportAgentSimulation.registerEntity(this, HackerAgent.TYPE_ID, HackerAgent::class.java
            )
        } catch (exception: ConfigurationFormatException) {
            exception.printStackTrace()
        }
    }

}