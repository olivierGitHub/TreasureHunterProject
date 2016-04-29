var React = require('react');

var Help = React.createClass({
    render: function () {
        return (
            <div>
                <h1>la carte aux trésors !</h1>
                <p>L’objectif de cet exercice est de réaliser un programme assez simple avec quelques objets métiers
                    (carte, aventurier, montagne, trésors …), un peu d’algorithme et de l’I/O.</p>
                <p>le premier sprint (must have) a pour objectif de réaliser le coeur du « domaine » c’est à dire
                    permettre de déplacer un aventurier sur une carte pour y ramasser les trésors tout en évitant les
                    montagnes. On peut connaître à tout moment la position de l’aventurier et le nombre de trésors
                    ramassés !</p>
                <p>le deuxième sprint (should have) offre la possibilité d’entrer dans le programme les commandes
                    d’un ou de plusieurs aventuriers ainsi que de définir la carte à partir de fichier textes. De même
                    le résultat de l’ensemble des positions et des trésors des aventuriers à la fin des déplacements
                    sera fourni dans un fichier de sortie.</p>
                <p>le troisième sprint (nice to have) est beaucoup plus ambitieux : faire en sorte de gérer le timing
                    de déplacement d’un aventurier et introduire la possibilité d’avoir plusieurs aventuriers qui se
                    déplacent de façon asynchrone. </p>
            </div>
        );
    }
});


module.exports = Help;
