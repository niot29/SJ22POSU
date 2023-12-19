var pages = {
    'home': `HOME Welcome . This is our home page!<br/><br/`,
    'jel': `Jarkarta Expression Language. !<br/><br/ <p>JEL &auml;r server side teknik som ursprungligen utformats f&ouml;r att tillfredsst&auml;lla de specifika behoven hos utvecklare av webbapplikationer. Den har utvecklats till en egen specifikation avsedd f&ouml;r allm&auml;n anv&auml;ndning i och utanf&ouml;r webbeh&aring;llare. K&auml;rnan i uttrycksspr&aring;ket &auml;r f&ouml;rest&auml;llningen om ett uttryck som tolkas enligt grammatiken som definieras av uttrycksspr&aring;ket.K&auml;rnan i uttrycksspr&aring;ket &auml;r f&ouml;rest&auml;llningen om ett uttryck som tolkas enligt grammatiken som definieras av uttrycksspr&aring;ket.</p>`,
    'jsp': `JSP står för Java Server Pages. !<br/><br/ <p>&middot; Anv&auml;nds fr&auml;mst f&ouml;r presentation lager f&ouml;r applikationer &middot; JSP kod &auml;r mer lik HTML fast inkluderar java kod &middot; JSP &auml;r komplement/ut&ouml;kning av servlet. Varje JSP sida konverterar f&ouml;rst i servlet av JSP-container innan sj&auml;lve process av klient anropet. &middot; Rent HTML kan enkelt konvertera till JSP genom att bara bytta fil &auml;ndelse. .html till .jsp och definiera i f&ouml;rsta raden att filen &auml;r en html <%- &ndash; JSP Comment. - -%>. Java kod i filen kallas f&ouml;r &rdquo;scriptlet&rdquo; och definierar med f&ouml;ljande kod block <% .. .JAVA KOD; %> &middot; Vad som skiljer html fr&aring;n jsp &auml;r att man kan baka in java kod i.  &middot; Beroende p&aring; var requesten kommer ifr&aring;n s&aring; finns det tv&aring; typer av JSP varianter  o Model1 arkitektur: I modelen s&aring; har JSP hand om klient kommunikationen. JSP skapar java bean som utf&ouml;r f&ouml;rfr&aring;gningen. Java Bean svarar JSP som sedan skickar servaret tillbaka till klienten</p>

    <p>o Model2 arkitektur: Sj&auml;lvs servlet tar emot request fr&aring;n klienten och skickar den vidare till JSP. JSP skapar en java bean som utf&ouml;r processen och svara tillbaka till JSP. JSP skickar svar tillbaka till klienten.</p>
    
    <p>&middot; F&ouml;rdel med JSP igenom f&ouml;r med Servlet &auml;r att den har b&auml;ttre prestanda, &ouml;ver micket fr&aring;n java teknik, med JSP s&aring; separera men inneh&aring;ll process fr&aring;n presentationen.</p>`,
    'jsf': `JSF står för Java Server Faces. <br/><br/> <p>&Auml;r ocks&aring; en server side teknik f&ouml;r att skapa webb applikationer. Liknade de JSP s&aring; inneh&aring;ller den m&aring;nga API och Interfacert tillg&auml;ngliga. JavaServer Faces-tekniken &auml;r designad f&ouml;r att vara flexibel och utnyttjar befintliga standardkoncept f&ouml;r anv&auml;ndargr&auml;nssnitt och webbniv&aring; utan att begr&auml;nsa utvecklare till ett visst uppm&auml;rkningsspr&aring;k, protokoll eller klientenhet.  Klasserna f&ouml;r UI-komponenter som ing&aring;r i JavaServer Faces-teknologin kapslar in komponentfunktionaliteten, inte den klientspecifika presentationen,  vilket g&ouml;r att JavaServer Faces UI-komponenter kan renderas till olika klientenheter. Genom att kombinera UI-komponentens funktionalitet med anpassade renderare,  som definierar renderingsattribut f&ouml;r en specifik UI-komponent, kan utvecklare konstruera anpassade taggar till en viss klientenhet.  Som en bekv&auml;mlighet tillhandah&aring;ller JavaServer Faces-tekniken en anpassad renderare och ett anpassat JSP-taggbibliotek f&ouml;r rendering till en HTML-klient,  vilket g&ouml;r att utvecklare av Java Platform, Enterprise Edition (Java EE)-applikationer kan anv&auml;nda JavaServer Faces-teknologi i sina applikationer.</p>`,
    'reflection': `reflection  Our Contact Us page<br/><br/> <p>Alla dessa tre tekniker &auml;r server sida redigering, vilket inneb&auml;r att presentation av de grafiks sker p&aring; server sidan och m&aring;ste skicka &ouml;ver till klienten. Klienten &auml;r beroende av att allt informationen skickad med och vid minimal f&ouml;r&auml;ndring p&aring; sidan s&aring; m&aring;ste hela processen g&ouml;ras om igen . B&aring;da frontend och backend utvecklar har ett stort beroende av varandra. B&aring;de m&aring;ste ha en bra grund kunskap av den andras utvecklings omr&aring;det. Kommunikation och dialog och &ouml;verenskommelse mellan front- backend m&aring;ste sker kontinuerligt .</p>

    <p> Att anv&auml;nda &rdquo;server side&rdquo; teknik eller inte &auml;r lite beroende p&aring; vilken typ av applikation samt vilka trafik belastning som det kan t&auml;nka vara. Oftast s&aring; betraktat &rdquo;server side&rdquo; ramverka att vara mer stabil och att det inte tar resurs p&aring; klient systemet. Men samtidig s&aring; har dagen teknik p&aring; klient sidan g&aring;r fram och resursen p&aring; de skall inte vara n&aring;gra problem dagsl&auml;get.  Teknik anv&auml;nds fortfarande, i synlighet i st&ouml;rre monilita applikationer.</p>
    
    <p> Med att l&aring;ta klienten sk&ouml;ta ber&auml;kningen av det grafiska s&aring; avlastar man &auml;ven webbserven, Samt utveckling process f&ouml;r front- och backend kan ske utan att ha st&ouml;rre beroende av varandra. B&aring;da milj&ouml;n kan arbeta frist&aring;ende s&aring; l&auml;nga de kar kommit &ouml;verens om &ouml;verf&ouml;ring och data format.</p>
    
    <p>Som sagt vad av teknik &auml;r beroende av vilken typ av system man vill bygga, sj&auml;lvs s&aring; skulle jag f&ouml;redra &rdquo;client side&rdquo; tekniken. Mycket f&ouml;r att separationen mellan front och backend. Vilket g&ouml;r att man &auml;r mer dynamsiks vid &ouml;nskad f&ouml;r&auml;ndring av frontsidan. </p>`
};

function getPageContent(page) {
    var contentToReturn;
    switch (page) {
        case 'home':
            contentToReturn = pages.home;
            break;
        case 'jel':
            contentToReturn = pages.jel;
            break;
        case 'jsp':
            contentToReturn = pages.jsp;
            break;
        case 'jsf':
            contentToReturn = pages.jsf;
            break;
        case 'reflection':
            contentToReturn = pages.reflection;
            break;
        default:
            contentToReturn = pages.home;
            break;
    }
    document.getElementById('content').innerHTML = contentToReturn;
}