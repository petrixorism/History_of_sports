package uz.gita.historyofsports.model

import uz.gita.historyofsports.R
import uz.gita.historyofsports.SharedPref

class Repository {

    fun getSportList(): List<Sport> {
        val list = ArrayList<Sport>()

        list.add(Sport("Baseball", R.drawable.ic_baseball, R.string.Baseball))
        list.add(Sport("Cycling", R.drawable.ic_bike, R.string.Bike))
        list.add(Sport("Gym", R.drawable.ic_gym, R.string.Gym))
        list.add(Sport("Hockey", R.drawable.ic_hockey, R.string.Hockey))
        list.add(Sport("Ice skating", R.drawable.ic_iceskating, R.string.Ice_skating))
        list.add(Sport("Run", R.drawable.ic_run, R.string.Run))
        list.add(Sport("Football", R.drawable.ic_soccer, R.string.Soccer))
        list.add(Sport("Tennis", R.drawable.ic_tennis, R.string.Tennis))
        list.add(Sport("Volleyball", R.drawable.ic_volleyball, R.string.Volleyball))
        list.add(Sport("Yoga", R.drawable.ic_yoga, R.string.Yoga))

        return list
    }

    fun getSportData(sport: String): Sport =
        getSportList().first {
            it.title == sport
        }

    fun getIsDayMode(): Boolean =
        SharedPref.getInstance().isDayMode

    fun setMode(isDayMode: Boolean) {
        SharedPref.getInstance().isDayMode = isDayMode
    }

}