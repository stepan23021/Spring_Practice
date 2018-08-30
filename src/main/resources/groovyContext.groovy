import com.example.dmitrii.spring_practice.gemini.GeminiFirstStage
import com.example.dmitrii.spring_practice.gemini.GeminiFuelType
import com.example.dmitrii.spring_practice.gemini.GeminiSecondStage
import com.example.dmitrii.spring_practice.gemini.GeminiThirdStage
import com.example.dmitrii.spring_practice.rockets.Apollo
import com.example.dmitrii.spring_practice.saturn.SaturnFirstStage
import com.example.dmitrii.spring_practice.saturn.SaturnFuelType
import com.example.dmitrii.spring_practice.saturn.SaturnSecondStage
import com.example.dmitrii.spring_practice.saturn.SaturnThirdStage

beans{

    saturnFuelType(SaturnFuelType)
    saturnFirstStage(SaturnFirstStage)
    saturnSecondStage(SaturnSecondStage)
    saturntThirdStage(SaturnThirdStage)

    saturn(Apollo,saturnFuelType,saturnFirstStage,saturnSecondStage,saturntThirdStage){
        serialNumber = 1234567890
        hustonWeHaveAProblem = false
        camouflage = "Black"
    }

    geminiFuelType(GeminiFuelType)
    geminiFirstStage(GeminiFirstStage)
    geminiSecondStage(GeminiSecondStage)
    geminiThirdStage(GeminiThirdStage)

    gemini(Apollo,geminiFuelType,geminiFirstStage,geminiSecondStage,geminiThirdStage){
        serialNumber = 0987654321
        hustonWeHaveAProblem = true
        camouflage = "White"
    }

}