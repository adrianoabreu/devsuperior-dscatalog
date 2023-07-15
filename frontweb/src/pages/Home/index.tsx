import { ReactComponent as MainImage } from 'assets/images/main-image.svg';
import ButtonIcon from 'components/ButtonIcon';
import { Link } from 'react-router-dom';
import './styles.css';
import {  isAuthenticated } from 'util/requests';
import TestChildren from 'components/TestChildren';

const Home = () => {
  return (
    <div className="home-container">

      <h1>{isAuthenticated() ? 'autenticado' : 'Não autenticado'}</h1>
      
      <TestChildren price={234.56}> 
        <h2>Conteúdo 1</h2>
        <h2>Conteúdo 2</h2>
      </TestChildren>
      <div className="base-card home-card">
        <div className="home-content-container">
          <div>
            <h1>Conheça o melhor catálogo de produtos</h1>
            <p>
              Ajudaremos você a encontrar os melhores produtos disponíveis no
              mercado.
            </p>
          </div>
          <div>
            <Link to="/products">
              <ButtonIcon text="Inicie agora a sua busca"/>
            </Link>
          </div>
        </div>
        <div className="home-image-container">
          <MainImage />
        </div>
      </div>
    </div>
  );
};

export default Home;
