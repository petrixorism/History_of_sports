package uz.gita.historyofsports.model

import uz.gita.historyofsports.R

class Repository {

    fun getSportList(): List<Sport> {
        val list = ArrayList<Sport>()

        list.add(Sport("Baseball", R.drawable.ic_baseball))
        list.add(Sport("Bike", R.drawable.ic_bike))
        list.add(Sport("Gym", R.drawable.ic_gym))
        list.add(Sport("Hockey", R.drawable.ic_hockey))
        list.add(Sport("Ice skating", R.drawable.ic_iceskating))
        list.add(Sport("Run", R.drawable.ic_run))
        list.add(Sport("Soccer", R.drawable.ic_soccer))
        list.add(Sport("Tennis", R.drawable.ic_tennis))
        list.add(Sport("Volleyball", R.drawable.ic_volleyball))
        list.add(Sport("Yoga", R.drawable.ic_yoga))

        return list
    }

}