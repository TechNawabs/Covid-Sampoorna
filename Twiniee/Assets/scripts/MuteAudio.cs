using System.Globalization;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MuteAudio : MonoBehaviour
{
    public AudioListener aListener;
    // Start is called before the first frame update
    public void onMuteClicked()
    {
        aListener.enabled = false;
    }
}
