let segments = window.segments;
console.log(segments);
console.log(segments[0]);

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
    // Basic alert of the segment text which is the prize name.
    alert("You have won " + winningSegment.text + "!");
}