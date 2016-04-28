var React = require('react');
var ReactDom = require('react-dom');

import { Router, Route} from 'react-router';
import { useRouterHistory } from 'react-router';
import { createHashHistory } from 'history';
const appHistory = useRouterHistory(createHashHistory)({ queryKey: false });

var Main = require('./components/main.js');
var Help = require('./components/help.js');

document.addEventListener("DOMContentLoaded", function(event) {

        ReactDom.render((
            <Router history={appHistory}>
                <Route path="/" component={Main} />
                <Route path="/help" component={Help} />
            </Router>
    ), document.getElementById('app'));


});
