package com.project.quizzapp

object Constants{
    const val USER_NAME:String="User_name"
    const val TOTAL_QUESTIONS:String="Total_question"
    const val CORRECT_ANSWERS: String="Correct_Answer"

    fun getQuestions():ArrayList<Question>{
        val questionList=ArrayList<Question>()

        questionList.add(Question(
                1,
            "What is the name of the character below",
                R.drawable.question1_seryu,
                "Seryu",
                "Sora",
                "Shyra",
                "Seury",
            1
                ))

        questionList.add(Question(
            2,
            "What is the name of the character below",
            R.drawable.question2,
            "Shirato",
            "Hercules",
            "Aquiles",
            "Arquiles",
            3
        ))

        questionList.add(Question(
            3,
            "What is the name of the character below",
            R.drawable.question3_colonello,
            "Sayku",
            "Colonello",
            "Sora",
            "Sargent",
            2
        ))

        questionList.add(Question(
            4,
            "What is the name of the character below",
            R.drawable.question4_shuichi,
            "Shuichi",
            "Sarkis",
            "Sakuto",
            "Boruto",
            1
        ))

        questionList.add(Question(
            5,
            "What is the name of the character below",
            R.drawable.question5_toudou_kirin,
            "Todou Kirin",
            "Kirato Azuna",
            "Sakura Tonoka",
            "Karin Kato",
            1
        ))

        questionList.add(Question(
            6,
            "What is the name of the character below",
            R.drawable.question6_shizue_izawa,
            "Akize Aru",
            "Sorano Ikawaki",
            "Soprano Akiza",
            "Shizue Izawa",
            4
        ))

        questionList.add(Question(
            7,
            "What is the name of the character below",
            R.drawable.question7_yuya_mirokuji,
            "Hado Tamane",
            "Hytsu tondo",
            "Yuya Mirokuji",
            "Yato Kurutsumagane",
            3
        ))

        questionList.add(Question(
            8,
            "What is the name of the character below",
            R.drawable.question8_gilgamesh,
            "Gito Aru",
            "Gilgamesh",
            "Gandronel",
            "Gatsu Izawa",
            2
        ))


        return questionList;
    }
}