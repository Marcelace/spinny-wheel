let segments = window.segments;

const coloredSegments = segments.map((segment, i) => {
        const hue = (i * 360) / segments.length;
        return {
            ...segment,
            fillStyle: "hsl(" + hue + ", 70%, 60%)"
        };
    }
)

let theWheel = new Winwheel({
    'numSegments': coloredSegments.length,
    'segments': coloredSegments,
    'pointerAngle' : 90,	// Ensure this is set correctly
    'animation':                   // Note animation properties passed in constructor parameters.
        {
            'type': 'spinToStop',  // Type of animation.
            'duration': 5,             // How long the animation is to take in seconds.
            'spins': 8,              // The number of complete 360 degree rotations the wheel is to do.
            'callbackFinished' : alertPrize
        },
});

function alertPrize()
{
    // Call getIndicatedSegment() function to return pointer to the segment pointed to on wheel.
    let winningSegment = theWheel.getIndicatedSegment();
    const resultText = document.getElementById("resultText");
    resultText.textContent = winningSegment.text;
    const resultDescription = document.getElementById("resultDescription");
    resultDescription.textContent = winningSegment.description;

    const modal = new bootstrap.Modal(document.getElementById("resultModal"));
    modal.show();



}