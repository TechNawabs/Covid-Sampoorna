using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class UnmuteAudio : MonoBehaviour
{
    public AudioListener audioListener;

    public void unmuteMyAudio(){
        audioListener.enabled = true;
    }
}
